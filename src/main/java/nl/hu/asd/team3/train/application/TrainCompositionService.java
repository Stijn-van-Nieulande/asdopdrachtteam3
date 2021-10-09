package nl.hu.asd.team3.train.application;


import nl.hu.asd.team3.train.data.RollingStockRepository;
import nl.hu.asd.team3.train.data.TrainCompositionRepository;
import nl.hu.asd.team3.train.domain.RollingStock;
import nl.hu.asd.team3.train.domain.TrainComposition;
import nl.hu.asd.team3.train.presentation.dto.inputRollingStockDTO;

public class TrainCompositionService {

    private TrainCompositionRepository trainCompositionRepository;
    private RollingStockRepository rollingStockRepository;

    public TrainCompositionService(TrainCompositionRepository trainCompositionRepository, RollingStockRepository rollingStockRepository) {
        this.trainCompositionRepository = trainCompositionRepository;
        this.rollingStockRepository = rollingStockRepository;
    }

    public void addRollingStockToTrainComposition(int t, inputRollingStockDTO i){
        TrainComposition trainComp = trainCompositionRepository.findById(t);
        RollingStock rollingStock = trainComp.addRollingStockDTO(i);
//        rollingStockRepository.save(rollingStock);
//        trainCompositionRepository.save(trainComp);
    }

}
