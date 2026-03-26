package org.example.eventregistrationsystem.repository;

import org.example.eventregistrationsystem.entity.EventRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Roman Gulevatiy on 26.03.2026.
 * github github.com/RomanGulevatiy
 */
@Repository
public interface EventRegistrationRepository extends JpaRepository<EventRegistration, Long> {

    long countByEventId(Long eventId);

    boolean existsByEventIdAndStudentId(Long eventId, Long studentId);
}
