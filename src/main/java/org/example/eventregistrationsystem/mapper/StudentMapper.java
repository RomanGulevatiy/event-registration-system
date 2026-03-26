package org.example.eventregistrationsystem.mapper;

import org.example.eventregistrationsystem.dto.request.CreateStudentRequest;
import org.example.eventregistrationsystem.dto.response.StudentCardResponse;
import org.example.eventregistrationsystem.dto.response.StudentResponse;
import org.example.eventregistrationsystem.entity.Student;
import org.example.eventregistrationsystem.entity.StudentCard;
import org.springframework.stereotype.Component;

/**
 * Created by Roman Gulevatiy on 26.03.2026.
 * github github.com/RomanGulevatiy
 */
@Component
public class StudentMapper {

    public Student toEntity(CreateStudentRequest request) {
        return Student.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .group(request.getGroup())
                .build();
    }

    public StudentResponse toResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .fullName(student.getFullName())
                .email(student.getEmail())
                .group(student.getGroup())
                .studentCard(toCardResponse(student.getStudentCard()))
                .createdAt(student.getCreatedAt())
                .build();
    }

    public StudentCardResponse toCardResponse(StudentCard card) {
        if (card == null) return null;
        return StudentCardResponse.builder()
                .id(card.getId())
                .cardToken(card.getCardToken())
                .expiryDate(card.getExpiryDate())
                .isActive(card.isActive())
                .issuedAt(card.getIssuedAt())
                .build();
    }
}
