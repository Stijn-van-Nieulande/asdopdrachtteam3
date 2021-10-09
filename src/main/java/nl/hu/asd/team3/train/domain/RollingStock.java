package nl.hu.asd.team3.train.domain;

public class RollingStock {
    private TrainComposition trainComposition;

    public RollingStock() {
    }

    public RollingStock setTrainComposition(TrainComposition trainComposition) {
        this.trainComposition = trainComposition;
        System.out.println(this.trainComposition);
        return this;
    }
}
