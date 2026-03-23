package org.example.eventregistrationsystem.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.eventregistrationsystem.dto.request.CreateEventRequest;
import org.example.eventregistrationsystem.dto.response.EventResponse;
import org.example.eventregistrationsystem.entity.Event;
import org.example.eventregistrationsystem.mapper.EventMapper;
import org.example.eventregistrationsystem.repository.EventRepository;
import org.example.eventregistrationsystem.service.EventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Roman Gulevatiy on 22.03.2026.
 * github github.com/RomanGulevatiy
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
@Slf4j
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Transactional
    @Override
    public EventResponse createEvent(CreateEventRequest createEventRequest) {
        Event event = eventMapper.createRequestToEntity(createEventRequest);
        Event saved = eventRepository.save(event);
        log.info("Event with id {} created", saved.getId());
        return eventMapper.entityToResponse(saved);
    }

    @Override
    public List<EventResponse> getActiveEvents() {
        return eventRepository.findAllByEventDateAfter(LocalDateTime.now())
                .stream()
                .map(eventMapper::entityToResponse)
                .toList();
    }
}
