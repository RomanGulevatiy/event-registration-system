package org.example.eventregistrationsystem.service;

import org.example.eventregistrationsystem.dto.CreateEventRequest;
import org.example.eventregistrationsystem.dto.EventResponse;
import org.example.eventregistrationsystem.dto.ParticipantResponse;
import org.example.eventregistrationsystem.dto.RegisterParticipantRequest;

import java.util.List;

/**
 * Created by Roman Gulevatiy on 20.03.2026.
 * github github.com/RomanGulevatiy
 */
public interface EventService {

    EventResponse createEvent(CreateEventRequest createEventRequest);

    ParticipantResponse registerParticipant(Long eventId, RegisterParticipantRequest registerParticipantRequest);

    List<EventResponse> getActiveEvents();
}
