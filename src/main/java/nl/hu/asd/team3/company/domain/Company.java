package nl.hu.asd.team3.company.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
//@Author Huib van Steenpaal

@Entity
public class Company {

    private String name;

    @Id
    private String code;

    public Company(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Company() {

    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.code = id;
    }

    @Id
    public String getId() {
        return code;
    }
}
