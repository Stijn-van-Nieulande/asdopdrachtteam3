package nl.hu.asd.team3.train.domain;

public class RollingStock {
    private int position;
    private String stockType;

    private TrainComposition trainComposition;

    public RollingStock() {
    }

    public RollingStock(int position, String stockType) {
        this.position = position;
        this.stockType = stockType;
    }

    public RollingStock setTrainComposition(TrainComposition trainComposition) {
        this.trainComposition = trainComposition;
        System.out.println(this.trainComposition);
        return this;
    }
}
