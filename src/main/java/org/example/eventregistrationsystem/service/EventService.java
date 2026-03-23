package org.example.eventregistrationsystem.service;

import org.example.eventregistrationsystem.dto.request.CreateEventRequest;
import org.example.eventregistrationsystem.dto.response.EventResponse;

import java.util.List;

/**
 * Created by Roman Gulevatiy on 20.03.2026.
 * github github.com/RomanGulevatiy
 */
public interface EventService {

    EventResponse createEvent(CreateEventRequest createEventRequest);

    List<EventResponse> getActiveEvents();
}
