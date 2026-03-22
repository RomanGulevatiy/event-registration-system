package org.example.eventregistrationsystem.mapper;

import org.example.eventregistrationsystem.dto.CreateEventRequest;
import org.example.eventregistrationsystem.dto.EventResponse;
import org.example.eventregistrationsystem.dto.UpdateEventRequest;
import org.example.eventregistrationsystem.entity.Event;
import org.springframework.stereotype.Component;

/**
 * Created by Roman Gulevatiy on 22.03.2026.
 * github github.com/RomanGulevatiy
 */
@Component
public class EventMapper {

    public Event createRequestToEntity(CreateEventRequest createEventRequest) {
        return Event.builder()
                .eventName(createEventRequest.getEventName())
                .eventDate(createEventRequest.getEventDate())
                .availableSeats(createEventRequest.getAvailableSeats())
                .build();
    }

    public Event updateRequestToEntity(UpdateEventRequest updateEventRequest) {
        return Event.builder()
                .eventName(updateEventRequest.getEventName())
                .eventDate(updateEventRequest.getEventDate())
                .availableSeats(updateEventRequest.getAvailableSeats())
                .build();
    }

    public EventResponse entityToResponse (Event event) {
        return EventResponse.builder()
                .id(event.getId())
                .eventName(event.getEventName())
                .eventDate(event.getEventDate())
                .availableSeats(event.getAvailableSeats())
                .createdAt(event.getCreatedAt())
                .build();
    }
}
