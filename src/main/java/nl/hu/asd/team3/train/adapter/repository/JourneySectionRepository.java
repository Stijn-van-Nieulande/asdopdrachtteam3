package nl.hu.asd.team3.train.adapter.repository;

import nl.hu.asd.team3.train.domain.JourneySection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JourneySectionRepository extends JpaRepository<JourneySection, Long> {
    Optional<JourneySection> findByIdAndCustomerId(Long id, Long customerId);
}
