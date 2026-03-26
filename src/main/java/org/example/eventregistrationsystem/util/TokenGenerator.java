package org.example.eventregistrationsystem.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Created by Roman Gulevatiy on 26.03.2026.
 * github github.com/RomanGulevatiy
 */
@Component
public class TokenGenerator {

    public String generateToken(Long studentId, LocalDate expiryDate) {
        String random = UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 8)
                .toUpperCase();

        return "STU-" +
                studentId + "-" +
                expiryDate.format(DateTimeFormatter.BASIC_ISO_DATE) + "-" +
                random;
    }
}
