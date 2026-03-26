package org.example.eventregistrationsystem.exception;

/**
 * Created by Roman Gulevatiy on 23.03.2026.
 * github github.com/RomanGulevatiy
 */
public class NoAvailableSeatsException extends RuntimeException {

    public NoAvailableSeatsException(String name) {
        super("No available seats for event '" + name + "'");
    }
}
