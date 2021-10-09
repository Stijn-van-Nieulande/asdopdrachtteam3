package nl.hu.asd.team3.train.domain;

import nl.hu.asd.team3.train.application.RollingStockService;
import nl.hu.asd.team3.train.presentation.dto.inputRollingStockDTO;

import java.util.List;

public class TrainComposition {
    private String brakeType;
    private int livestockOrPeopleIndicator;

    private List<RollingStock> rollingStocks;
    
    public TrainComposition() {
    }

    public TrainComposition(String brakeType, int livestockOrPeopleIndicator) {
        this.brakeType = brakeType;
        this.livestockOrPeopleIndicator = livestockOrPeopleIndicator;
    }
    
    public RollingStock addRollingStockDTO(inputRollingStockDTO i) {
        RollingStock rollingStock = new RollingStockService().createRollingStockFromDTO(i);
        rollingStock = rollingStock.setTrainComposition(this);
        addRollingStock(rollingStock);

        return rollingStock;
    }

    public void addRollingStock(RollingStock rollingStock){
        rollingStocks.add(rollingStock);
    }
}
