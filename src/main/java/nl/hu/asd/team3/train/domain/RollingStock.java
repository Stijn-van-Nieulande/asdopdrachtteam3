package nl.hu.asd.team3.train.domain;

import javax.persistence.*;

@Entity
public class RollingStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position")
    private int position;

    @Column(name = "stocktype")
    private String stockType;

    @ManyToOne
    @JoinColumn(name = "train_composition_id")
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

    public int getPosition() {
        return position;
    }

    public String getStockType() {
        return stockType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
