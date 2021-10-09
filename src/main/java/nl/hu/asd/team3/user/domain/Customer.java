package nl.hu.asd.team3.user.domain;

import nl.hu.asd.team3.user.adapter.service.UserService;

import java.util.List;

public class Customer {
    private Object company;
    private String name;
    private String iban;
    private int kvk;

    private List<User> users;

    public Customer(String companyCode, String customerName, String iban, int kvk){
        this.company = UserService.getCompanyByCode(companyCode);
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
        return false; //change
    }
}
