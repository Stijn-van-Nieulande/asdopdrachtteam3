package nl.hu.asd.team3.train.adapter.service;

import nl.hu.asd.team3.company.adapter.CompanyRESTService;
import nl.hu.asd.team3.company.adapter.LocationRESTService;
import nl.hu.asd.team3.train.application.TrainApplicationService;
import nl.hu.asd.team3.train.domain.Train;
import nl.hu.asd.team3.train.domain.dto.TrainDTO;
import nl.hu.asd.team3.user.adapter.SecurityContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainRESTService {
    private final TrainApplicationService trainApplicationService;

    public TrainRESTService(TrainApplicationService trainApplicationService){
        this.trainApplicationService = trainApplicationService;
    }

    public Train createTrain(@Validated @RequestBody TrainDTO trainDTO, LocationRESTService locationRESTService, CompanyRESTService companyRESTService, SecurityContext securityContext){
        return trainApplicationService.createTrain(trainDTO, locationRESTService, companyRESTService, securityContext);
    }
}
