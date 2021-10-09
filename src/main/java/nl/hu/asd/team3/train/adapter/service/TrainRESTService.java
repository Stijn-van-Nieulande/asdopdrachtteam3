package nl.hu.asd.team3.train.adapter.service;

import nl.hu.asd.team3.train.application.TrainApplicationService;
import nl.hu.asd.team3.train.domain.dto.TrainDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainRESTService {
    private final TrainApplicationService trainApplicationService;

    public TrainRESTService(TrainApplicationService trainApplicationService){
        this.trainApplicationService = trainApplicationService;
    }

    public void createTrain(@Validated @RequestBody TrainDTO trainDTO){
        trainApplicationService.createTrain(trainDTO);
    }
}
