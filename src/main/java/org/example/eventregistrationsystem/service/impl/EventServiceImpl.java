package org.example.eventregistrationsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.eventregistrationsystem.dto.CreateEventRequest;
import org.example.eventregistrationsystem.dto.EventResponse;
import org.example.eventregistrationsystem.dto.ParticipantResponse;
import org.example.eventregistrationsystem.dto.RegisterParticipantRequest;
import org.example.eventregistrationsystem.repository.EventRepository;
import org.example.eventregistrationsystem.repository.ParticipantRepository;
import org.example.eventregistrationsystem.service.EventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman Gulevatiy on 22.03.2026.
 * github github.com/RomanGulevatiy
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ParticipantRepository participantRepository;

    @Override
    public EventResponse createEvent(CreateEventRequest createEventRequest) {
        return null;
    }

    @Override
    public ParticipantResponse registerParticipant(Long eventId, RegisterParticipantRequest registerParticipantRequest) {
        return null;
    }

    @Override
    public List<EventResponse> getActiveEvents() {
        return List.of();
    }
}
