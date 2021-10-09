package nl.hu.asd.team3.train.application;


import nl.hu.asd.team3.train.domain.RollingStock;
import nl.hu.asd.team3.train.presentation.dto.inputRollingStockDTO;

public class RollingStockService {
    public RollingStockService() {
    }

    public RollingStock createRollingStockFromDTO(inputRollingStockDTO i) {
        return new RollingStock(i.position, i.stockType);
    }
}
