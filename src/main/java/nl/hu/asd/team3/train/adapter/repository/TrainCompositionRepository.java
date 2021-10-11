package nl.hu.asd.team3.train.adapter.repository;

import nl.hu.asd.team3.train.domain.TrainComposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainCompositionRepository extends JpaRepository<TrainComposition, Long> {

    Optional<TrainComposition> findById(Long id);
}
