package org.example.eventregistrationsystem.service;

import org.example.eventregistrationsystem.dto.request.CreateStudentRequest;
import org.example.eventregistrationsystem.dto.response.StudentResponse;

/**
 * Created by Roman Gulevatiy on 26.03.2026.
 * github github.com/RomanGulevatiy
 */
public interface StudentService {

    StudentResponse createStudent(CreateStudentRequest request);
}
