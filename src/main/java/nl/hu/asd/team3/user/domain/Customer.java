package nl.hu.asd.team3.user.domain;

import lombok.NoArgsConstructor;
import nl.hu.asd.team3.user.adapter.service.UserService;

import javax.persistence.*;
import java.util.ArrayList;


@NoArgsConstructor
@Entity
public class Customer {

    private Object company;
    private String name;
    private String iban;
    private int kvk;

    @Transient
    private ArrayList<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Customer(UserService service, String companyCode, String customerName, String iban, int kvk){
        this.company = service.getCompanyByCode(companyCode);
        this.name = customerName;
        this.iban = iban;
        this.kvk = kvk;
    }

    public Customer(String customerName, String iban, int kvk){
        this.name = customerName;
        this.iban = iban;
        this.kvk = kvk;
    }


    public boolean checkDuplicate() {
        return true; //change
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append(", company=").append(company);
        sb.append(", name='").append(name).append('\'');
        sb.append(", iban='").append(iban).append('\'');
        sb.append(", kvk=").append(kvk);
        sb.append(", users=").append(users);
        sb.append('}');
        return sb.toString();
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
