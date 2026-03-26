package org.example.eventregistrationsystem.repository;

import org.example.eventregistrationsystem.entity.StudentCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Roman Gulevatiy on 26.03.2026.
 * github github.com/RomanGulevatiy
 */
@Repository
public interface StudentCardRepository extends JpaRepository<StudentCard, Long> {

    Optional<StudentCard> findByCardToken(String cardToken);
}
