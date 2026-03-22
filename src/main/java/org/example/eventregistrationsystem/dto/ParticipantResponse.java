package org.example.eventregistrationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.eventregistrationsystem.entity.enums.RegistrationStatus;

import java.time.LocalDateTime;

/**
 * Created by Roman Gulevatiy on 20.03.2026.
 * github github.com/RomanGulevatiy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipantResponse {

    private Long id;

    private String name;

    private String email;

    private RegistrationStatus registrationStatus;

    private LocalDateTime registeredAt;
}
