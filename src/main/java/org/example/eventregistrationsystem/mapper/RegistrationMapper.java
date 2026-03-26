package org.example.eventregistrationsystem.mapper;

import org.example.eventregistrationsystem.dto.response.RegistrationResponse;
import org.example.eventregistrationsystem.entity.EventRegistration;
import org.springframework.stereotype.Component;

/**
 * Created by Roman Gulevatiy on 26.03.2026.
 * github github.com/RomanGulevatiy
 */
@Component
public class RegistrationMapper {

    public RegistrationResponse toResponse(EventRegistration registration) {
        return RegistrationResponse.builder()
                .id(registration.getId())
                .eventId(registration.getEvent().getId())
                .eventName(registration.getEvent().getEventName())
                .studentId(registration.getStudent().getId())
                .studentFullName(registration.getStudent().getFullName())
                .status(registration.getStatus())
                .registeredAt(registration.getRegisteredAt())
                .build();
    }
}
