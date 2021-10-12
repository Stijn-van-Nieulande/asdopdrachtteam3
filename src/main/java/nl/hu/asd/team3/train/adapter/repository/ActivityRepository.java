package nl.hu.asd.team3.train.adapter.repository;

import nl.hu.asd.team3.train.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, String> {
}
