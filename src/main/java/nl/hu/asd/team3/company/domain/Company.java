package nl.hu.asd.team3.company.domain;

import java.util.concurrent.ThreadLocalRandom;

public class Company
{
    //    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = ThreadLocalRandom.current().nextLong(1, 100000); // Just for demo
}
