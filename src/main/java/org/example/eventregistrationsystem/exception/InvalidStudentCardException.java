package org.example.eventregistrationsystem.exception;

/**
 * Created by Roman Gulevatiy on 26.03.2026.
 * github github.com/RomanGulevatiy
 */
public class InvalidStudentCardException extends RuntimeException {

    public InvalidStudentCardException(String reason) {
        super("Student card is invalid: " + reason);
    }
}
