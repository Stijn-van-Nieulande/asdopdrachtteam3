package nl.hu.asd.team3.user.user.adapter;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class SecurityContext
{
    public Long getCustomerId()
    {
        return ThreadLocalRandom.current().nextLong(1, 100000); // Just for demo
    }
}
