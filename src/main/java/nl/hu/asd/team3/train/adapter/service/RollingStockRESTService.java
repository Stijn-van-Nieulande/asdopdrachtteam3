package nl.hu.asd.team3.train.adapter.service;

import nl.hu.asd.team3.train.adapter.service.dto.inputRollingStockDTO;
import nl.hu.asd.team3.train.application.TrainCompositionService;
import nl.hu.asd.team3.train.domain.TrainComposition;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RollingStockRESTService {

    private final TrainCompositionService trainCompositionService;

    public RollingStockRESTService(TrainCompositionService trainCompositionService) {
        this.trainCompositionService = trainCompositionService;
    }

    public TrainComposition addRollingStock(Long trainCompositionId, inputRollingStockDTO inputRollingStockDTO) {
        return trainCompositionService.addRollingStockToTrainComposition(trainCompositionId, inputRollingStockDTO);
    }
}
