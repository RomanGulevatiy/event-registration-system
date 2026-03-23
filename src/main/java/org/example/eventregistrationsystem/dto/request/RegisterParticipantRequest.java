package org.example.eventregistrationsystem.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Roman Gulevatiy on 20.03.2026.
 * github github.com/RomanGulevatiy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterParticipantRequest {

    @NotBlank(message = "Participant name is required")
    private String name;

    @NotBlank(message = "Participant group is required")
    private String group;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Participant email is required")
    private String email;

    /// Status will be set to PENDING by default when registering a participant
}
