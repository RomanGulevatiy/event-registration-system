package org.example.eventregistrationsystem.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.eventregistrationsystem.entity.enums.RegistrationStatus;

/**
 * Created by Roman Gulevatiy on 20.03.2026.
 * github github.com/RomanGulevatiy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateParticipantRequest {

    @NotBlank(message = "Participant name is required")
    private String name;

    @NotBlank(message = "Participant group is required")
    private String group;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Participant email is required")
    private String email;

    @NotNull(message = "Registration status is required")
    private RegistrationStatus registrationStatus;
}
