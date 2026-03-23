package org.example.eventregistrationsystem.repository;

import org.example.eventregistrationsystem.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Roman Gulevatiy on 20.03.2026.
 * github github.com/RomanGulevatiy
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByEventDateAfter(LocalDateTime date);
}
