package org.example.eventregistrationsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.eventregistrationsystem.entity.enums.RegistrationStatus;

import java.time.LocalDateTime;

/**
 * Created by Roman Gulevatiy on 26.03.2026.
 * github github.com/RomanGulevatiy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationResponse {

    private Long id;

    private Long eventId;

    private String eventName;

    private Long studentId;

    private String studentFullName;

    private RegistrationStatus status;

    private LocalDateTime registeredAt;
}
