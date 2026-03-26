package org.example.eventregistrationsystem.exception;

/**
 * Created by Roman Gulevatiy on 23.03.2026.
 * github github.com/RomanGulevatiy
 */
public class DuplicateEmailException extends RuntimeException {

    public DuplicateEmailException(String email) {
        super("Student with email '" + email + "' already exists");
    }
}
