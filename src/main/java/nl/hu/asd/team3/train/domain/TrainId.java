package nl.hu.asd.team3.train.domain;

import java.util.concurrent.ThreadLocalRandom;

public class TrainId {
    // Because there is no real database, I use random number generator to get the next ID.
    private Long id = ThreadLocalRandom.current().nextLong(0, 99999999);

    public TrainId() {
    }

    public Long getId() {
        return id;
    }
}
