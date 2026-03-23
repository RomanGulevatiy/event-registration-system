package org.example.eventregistrationsystem.mapper;

import org.example.eventregistrationsystem.dto.response.ParticipantResponse;
import org.example.eventregistrationsystem.dto.request.RegisterParticipantRequest;
import org.example.eventregistrationsystem.dto.request.UpdateParticipantRequest;
import org.example.eventregistrationsystem.entity.Participant;
import org.springframework.stereotype.Component;

/**
 * Created by Roman Gulevatiy on 22.03.2026.
 * github github.com/RomanGulevatiy
 */
@Component
public class ParticipantMapper {

    public Participant registerRequestToEntity(RegisterParticipantRequest registerParticipantRequest) {
        return Participant.builder()
                .name(registerParticipantRequest.getName())
                .group(registerParticipantRequest.getGroup())
                .email(registerParticipantRequest.getEmail())
                .build();
    }

    public Participant updateRequestToEntity(UpdateParticipantRequest updateParticipantRequest) {
        return Participant.builder()
                .name(updateParticipantRequest.getName())
                .group(updateParticipantRequest.getGroup())
                .email(updateParticipantRequest.getEmail())
                .registrationStatus(updateParticipantRequest.getRegistrationStatus())
                .build();
    }

    public ParticipantResponse entityToResponse(Participant participant) {
        return ParticipantResponse.builder()
                .id(participant.getId())
                .name(participant.getName())
                .email(participant.getEmail())
                .registrationStatus(participant.getRegistrationStatus())
                .eventId(participant.getEvent().getId())
                .registeredAt(participant.getRegisteredAt())
                .build();
    }
}
