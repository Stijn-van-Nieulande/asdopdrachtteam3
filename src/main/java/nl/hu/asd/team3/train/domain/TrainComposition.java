package nl.hu.asd.team3.train.domain;

import lombok.NoArgsConstructor;
import nl.hu.asd.team3.train.domain.exceptions.InvalidInputException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
public class TrainComposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brakeType;
    private int livestockOrPeopleIndicator;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "trainComposition")
    @OrderBy("position")
    @OrderColumn(name = "position")
    private List<RollingStock> rollingStocks = new ArrayList<>();


    public TrainComposition(String brakeType, int livestockOrPeopleIndicator) {
        this.brakeType = brakeType;
        this.livestockOrPeopleIndicator = livestockOrPeopleIndicator;
    }
    
    public RollingStock addRollingStockDTO(Integer position, String stockType) {
        if (position == null || stockType == null || stockType.isEmpty()){
            throw new InvalidInputException("position/stockType cannot be empty");
        }
        for (RollingStock r: rollingStocks) {
            if (r.getPosition() == position){
                throw new InvalidInputException("position: " + position + " is already being used");
            }
        }
        RollingStock rollingStock = new RollingStock(position, stockType);
        rollingStock = rollingStock.setTrainComposition(this);
        addRollingStock(rollingStock);

        return rollingStock;
    }

    public void addRollingStock(RollingStock rollingStock){
        rollingStocks.add(rollingStock);
    }

    public int getLivestockOrPeopleIndicator() {
        return livestockOrPeopleIndicator;
    }

    public String getBrakeType() {
        return brakeType;
    }

    public Long getId() { return id; }
}
