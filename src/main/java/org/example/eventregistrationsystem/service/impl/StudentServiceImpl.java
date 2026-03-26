package org.example.eventregistrationsystem.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.eventregistrationsystem.dto.request.CreateStudentRequest;
import org.example.eventregistrationsystem.dto.response.StudentResponse;
import org.example.eventregistrationsystem.entity.Student;
import org.example.eventregistrationsystem.entity.StudentCard;
import org.example.eventregistrationsystem.exception.DuplicateEmailException;
import org.example.eventregistrationsystem.mapper.StudentMapper;
import org.example.eventregistrationsystem.repository.StudentCardRepository;
import org.example.eventregistrationsystem.repository.StudentRepository;
import org.example.eventregistrationsystem.service.StudentService;
import org.example.eventregistrationsystem.util.TokenGenerator;
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
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentCardRepository studentCardRepository;
    private final StudentMapper studentMapper;

    private final TokenGenerator tokenGenerator;

    @Transactional
    @Override
    public StudentResponse createStudent(CreateStudentRequest request) {

        if(studentRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException(request.getEmail());
        }

        Student student = studentMapper.toEntity(request);
        Student savedStudent = studentRepository.save(student);

        LocalDate expiryDate = LocalDate.now().plusYears(4);
        String token = tokenGenerator.generateToken(savedStudent.getId(), expiryDate);

        StudentCard studentCard = StudentCard.builder()
                .cardToken(token)
                .expiryDate(expiryDate)
                .isActive(true)
                .student(savedStudent)
                .build();

        StudentCard savedStudentCard = studentCardRepository.save(studentCard);
        savedStudent.setStudentCard(savedStudentCard);

        log.info("Student created: id={}, card token={}", savedStudent.getId(), token);
        return studentMapper.toResponse(savedStudent);
    }
}
