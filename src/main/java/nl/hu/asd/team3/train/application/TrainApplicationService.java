package nl.hu.asd.team3.train.application;

import nl.hu.asd.team3.company.adapter.CompanyRESTService;
import nl.hu.asd.team3.company.adapter.LocationRESTService;
import nl.hu.asd.team3.train.adapter.repository.TrainRepository;
import nl.hu.asd.team3.train.adapter.service.TrainRESTService;
import nl.hu.asd.team3.train.adapter.service.TrainService;
import nl.hu.asd.team3.train.domain.Train;
import nl.hu.asd.team3.train.domain.dto.TrainDTO;
import nl.hu.asd.team3.user.adapter.SecurityContext;
import org.springframework.stereotype.Service;

@Service
public class TrainApplicationService {
    private final TrainRepository trainRepository;

    public TrainApplicationService(TrainRepository trainRepository){
        this.trainRepository = trainRepository;
    }

    public Train createTrain(TrainDTO trainDTO, LocationRESTService locationRESTService, CompanyRESTService companyRESTService, SecurityContext securityContext){
        return new Train(trainDTO.trainType, trainDTO.operationalTrainNumber, trainDTO.scheduledTimeAtHandover, trainDTO.scheduledDateTimeAtTransfer, trainDTO.companyCode, trainDTO.locationId, new TrainService(companyRESTService, locationRESTService, securityContext));
    }
}
