package nl.hu.asd.team3.train.adapter.repository;

import nl.hu.asd.team3.train.domain.TrainCompositionMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<TrainCompositionMessage, Long>
{
}
