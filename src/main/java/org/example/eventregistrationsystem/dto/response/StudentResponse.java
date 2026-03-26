package org.example.eventregistrationsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by Roman Gulevatiy on 26.03.2026.
 * github github.com/RomanGulevatiy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {

    private Long id;

    private String fullName;

    private String email;

    private String group;

    private StudentCardResponse studentCard;

    private LocalDateTime createdAt;
}
