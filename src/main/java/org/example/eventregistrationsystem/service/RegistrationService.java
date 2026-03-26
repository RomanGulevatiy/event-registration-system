package org.example.eventregistrationsystem.service;

import org.example.eventregistrationsystem.dto.request.RegisterToEventRequest;
import org.example.eventregistrationsystem.dto.response.RegistrationResponse;

/**
 * Created by Roman Gulevatiy on 26.03.2026.
 * github github.com/RomanGulevatiy
 */
public interface RegistrationService {

    RegistrationResponse registerToEvent(Long eventId, RegisterToEventRequest request);
}
