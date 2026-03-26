package org.example.eventregistrationsystem.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.eventregistrationsystem.dto.request.RegisterToEventRequest;
import org.example.eventregistrationsystem.dto.response.RegistrationResponse;
import org.example.eventregistrationsystem.entity.Event;
import org.example.eventregistrationsystem.entity.EventRegistration;
import org.example.eventregistrationsystem.entity.Student;
import org.example.eventregistrationsystem.entity.StudentCard;
import org.example.eventregistrationsystem.exception.AlreadyRegisteredException;
import org.example.eventregistrationsystem.exception.EventNotFoundException;
import org.example.eventregistrationsystem.exception.InvalidStudentCardException;
import org.example.eventregistrationsystem.exception.NoAvailableSeatsException;
import org.example.eventregistrationsystem.mapper.RegistrationMapper;
import org.example.eventregistrationsystem.repository.EventRegistrationRepository;
import org.example.eventregistrationsystem.repository.EventRepository;
import org.example.eventregistrationsystem.repository.StudentCardRepository;
import org.example.eventregistrationsystem.service.RegistrationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * Created by Roman Gulevatiy on 26.03.2026.
 * github github.com/RomanGulevatiy
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {

    private final EventRepository eventRepository;
    private final EventRegistrationRepository eventRegistrationRepository;
    private final StudentCardRepository studentCardRepository;
    private final RegistrationMapper registrationMapper;

    @Transactional
    @Override
    public RegistrationResponse registerToEvent(Long eventId, RegisterToEventRequest request) {

        StudentCard studentCard = studentCardRepository.findByCardToken(request.getCardToken())
                .orElseThrow(() -> new InvalidStudentCardException("token not found"));

        if(!studentCard.isActive()) {
            throw new InvalidStudentCardException("card is deactivated");
        }

        if(studentCard.getExpiryDate().isBefore(LocalDate.now())) {
            throw new InvalidStudentCardException("card expired on " + studentCard.getExpiryDate());
        }

        Student student = studentCard.getStudent();

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException(eventId));

        if(eventRegistrationRepository.existsByEventIdAndStudentId(eventId, student.getId())) {
            throw new AlreadyRegisteredException(student.getId(), eventId);
        }

        long currentRegistrations = eventRegistrationRepository.countByEventId(eventId);
        if(currentRegistrations >= event.getAvailableSeats()) {
            throw new NoAvailableSeatsException(event.getEventName());
        }

        EventRegistration eventRegistration = EventRegistration.builder()
                .event(event)
                .student(student)
                .build();

        EventRegistration savedEventRegistration = eventRegistrationRepository.save(eventRegistration);
        log.info("Student id={} registered to event id={}", student.getId(), eventId);
        return registrationMapper.toResponse(savedEventRegistration);
    }
}
