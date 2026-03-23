package org.example.eventregistrationsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.eventregistrationsystem.dto.request.RegisterParticipantRequest;
import org.example.eventregistrationsystem.dto.response.ParticipantResponse;
import org.example.eventregistrationsystem.service.ParticipantService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Roman Gulevatiy on 23.03.2026.
 * github github.com/RomanGulevatiy
 */
@RestController
@RequestMapping("/api/participants")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @PostMapping("/register/{eventId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ParticipantResponse registerToEvent(@PathVariable Long eventId,
                                               @Valid @RequestBody RegisterParticipantRequest registerParticipantRequest) {
        return participantService.registerToEvent(eventId, registerParticipantRequest);
    }
}
