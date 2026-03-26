package org.example.eventregistrationsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Roman Gulevatiy on 26.03.2026.
 * github github.com/RomanGulevatiy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCardResponse {

    private Long id;

    private String cardToken;

    private LocalDate expiryDate;

    private boolean isActive;

    private LocalDateTime issuedAt;
}
