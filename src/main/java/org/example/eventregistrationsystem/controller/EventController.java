package org.example.eventregistrationsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.eventregistrationsystem.dto.request.CreateEventRequest;
import org.example.eventregistrationsystem.dto.response.EventResponse;
import org.example.eventregistrationsystem.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Roman Gulevatiy on 23.03.2026.
 * github github.com/RomanGulevatiy
 */
@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponse createEvent(@Valid @RequestBody CreateEventRequest createEventRequest) {
        return eventService.createEvent(createEventRequest);
    }

    @GetMapping("/active")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getActiveEvents() {
        return eventService.getActiveEvents();
    }
}
