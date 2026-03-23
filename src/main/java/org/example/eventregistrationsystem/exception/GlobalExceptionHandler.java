package org.example.eventregistrationsystem.exception;

import org.example.eventregistrationsystem.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * Created by Roman Gulevatiy on 22.03.2026.
 * github github.com/RomanGulevatiy
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EventNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleEventNotFoundException(EventNotFoundException exception) {
        return ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .error(exception.getMessage())
                .message(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(NoAvailableSeatsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleNoAvailableSeatsException(NoAvailableSeatsException exception) {
        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .error(exception.getMessage())
                .message(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(DuplicateEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleDuplicateEmailException(DuplicateEmailException exception) {
        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .error(exception.getMessage())
                .message(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
