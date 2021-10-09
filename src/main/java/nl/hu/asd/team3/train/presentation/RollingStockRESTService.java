package nl.hu.asd.team3.train.presentation;


import nl.hu.asd.team3.train.application.TrainCompositionService;
import nl.hu.asd.team3.train.presentation.dto.inputRollingStockDTO;

public class RollingStockRESTService {

    private TrainCompositionService trainCompositionService;

    public RollingStockRESTService(TrainCompositionService trainCompositionService) {
        this.trainCompositionService = trainCompositionService;
    }

    public void addRollingStock(int trainCompositionId, inputRollingStockDTO inputRollingStockDTO) {
        trainCompositionService.addRollingStockToTrainComposition(trainCompositionId, inputRollingStockDTO);
    }
}
