package org.example.eventregistrationsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.eventregistrationsystem.dto.request.RegisterToEventRequest;
import org.example.eventregistrationsystem.dto.response.RegistrationResponse;
import org.example.eventregistrationsystem.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Roman Gulevatiy on 26.03.2026.
 * github github.com/RomanGulevatiy
 */
@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/{eventId}/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistrationResponse registerToEvent(@PathVariable Long eventId,
                                                @Valid @RequestBody RegisterToEventRequest registerToEventRequest) {
        return registrationService.registerToEvent(eventId, registerToEventRequest);
    }
}
