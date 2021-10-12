package nl.hu.asd.team3.user.domain;

import java.util.concurrent.ThreadLocalRandom;

public class CustomerId
{
    Long id;

    public Long getId() {
        return id;
    }

    public CustomerId(long id){
        this.id = id;
    }
}
