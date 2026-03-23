package org.example.eventregistrationsystem.service;

import org.example.eventregistrationsystem.dto.response.ParticipantResponse;
import org.example.eventregistrationsystem.dto.request.RegisterParticipantRequest;

/**
 * Created by Roman Gulevatiy on 23.03.2026.
 * github github.com/RomanGulevatiy
 */
public interface ParticipantService {

    ParticipantResponse registerToEvent(Long eventId, RegisterParticipantRequest registerParticipantRequest);
}
