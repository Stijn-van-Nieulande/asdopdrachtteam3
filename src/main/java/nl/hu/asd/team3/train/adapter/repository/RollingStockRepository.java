package nl.hu.asd.team3.train.adapter.repository;

import nl.hu.asd.team3.train.domain.RollingStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RollingStockRepository extends JpaRepository<RollingStock, Long> {

    @Override
    Optional<RollingStock> findById(Long aLong);
}
