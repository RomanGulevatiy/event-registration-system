package org.example.eventregistrationsystem.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.eventregistrationsystem.dto.response.ParticipantResponse;
import org.example.eventregistrationsystem.dto.request.RegisterParticipantRequest;
import org.example.eventregistrationsystem.entity.Event;
import org.example.eventregistrationsystem.entity.Participant;
import org.example.eventregistrationsystem.entity.enums.RegistrationStatus;
import org.example.eventregistrationsystem.exception.EventNotFoundException;
import org.example.eventregistrationsystem.exception.NoAvailableSeatsException;
import org.example.eventregistrationsystem.mapper.ParticipantMapper;
import org.example.eventregistrationsystem.repository.EventRepository;
import org.example.eventregistrationsystem.repository.ParticipantRepository;
import org.example.eventregistrationsystem.service.ParticipantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Roman Gulevatiy on 23.03.2026.
 * github github.com/RomanGulevatiy
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;
    private final EventRepository eventRepository;
    private final ParticipantMapper participantMapper;

    @Transactional
    @Override
    public ParticipantResponse registerToEvent(Long eventId, RegisterParticipantRequest registerParticipantRequest) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException(eventId));

        long registeredCounter = participantRepository.countByEventId(eventId);
        if(registeredCounter >= event.getAvailableSeats()) {
            throw new NoAvailableSeatsException(event.getEventName());
        }

        Participant participant = Participant.builder()
                .name(registerParticipantRequest.getName())
                .group(registerParticipantRequest.getGroup())
                .email(registerParticipantRequest.getEmail())
                .registrationStatus(RegistrationStatus.REGISTERED)
                .event(event)
                .build();

        Participant savedParticipant = participantRepository.save(participant);
        log.info("Participant with id {} registered to event with id {}", savedParticipant.getId(), eventId);
        return participantMapper.entityToResponse(savedParticipant);
    }
}
