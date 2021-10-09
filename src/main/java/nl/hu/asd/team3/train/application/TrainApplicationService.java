package nl.hu.asd.team3.train.application;

import nl.hu.asd.team3.train.adapter.repository.TrainRepository;
import nl.hu.asd.team3.train.adapter.service.TrainRESTService;
import nl.hu.asd.team3.train.domain.Train;
import nl.hu.asd.team3.train.domain.dto.TrainDTO;
import org.springframework.stereotype.Service;

@Service
public class TrainApplicationService {
    private final TrainRepository trainRepository;

    public TrainApplicationService(TrainRepository trainRepository){
        this.trainRepository = trainRepository;
    }

    public Train createTrain(TrainDTO trainDTO){
        Train train = new Train(trainDTO.trainType, trainDTO.operationalTrainNumber, trainDTO.scheduledTimeAtHandover, trainDTO.scheduledDateTimeAtTransfer);



        return train;
    }
}
