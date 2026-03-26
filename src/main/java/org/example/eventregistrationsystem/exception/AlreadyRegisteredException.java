package org.example.eventregistrationsystem.exception;

/**
 * Created by Roman Gulevatiy on 26.03.2026.
 * github github.com/RomanGulevatiy
 */
public class AlreadyRegisteredException extends RuntimeException {

    public AlreadyRegisteredException(Long studentId, Long eventId) {
        super("Student " + studentId + " is already registered for event " + eventId);
    }
}
