package nl.hu.asd.team3.user.domain;

import lombok.NoArgsConstructor;
import nl.hu.asd.team3.company.domain.Company;
import nl.hu.asd.team3.user.Exception.DupeException;
import nl.hu.asd.team3.user.Exception.NotFoundException;
import nl.hu.asd.team3.user.adapter.repository.CustomerRepository;
import nl.hu.asd.team3.user.adapter.service.UserService;

import javax.persistence.*;
import java.util.ArrayList;
//@Author Huib van Steenpaal

public class Customer {
    private Company company;
    private String name;
    private String iban;
    private int kvk;

    private ArrayList<User> users;

    private CustomerId id;

    public Customer(UserService service, CustomerRepository repo, String companyCode, String customerName, String iban, int kvk, long id) throws Exception {
        processCompanyCode(companyCode, service, repo);
        if(repo.findByKvK(kvk) != null){
            throw new DupeException("KvK match found");
        }
        this.company = service.getCompanyByCode(companyCode);
        this.name = customerName;
        this.iban = iban;
        this.kvk = kvk;
        this.id = new CustomerId(id);
    }

    public Customer(CustomerRepository repo, String customerName, String iban, int kvk, long id) throws DupeException {
        if(repo.findByKvK(kvk) != null){
            throw new DupeException("KvK match found");
        }
        this.name = customerName;
        this.iban = iban;
        this.kvk = kvk;
        this.id = new CustomerId(id);
    }


    // for test purposes only (Mock setup)
    public Customer(Company company, String customerName, String iban, int kvk, long id){
        this.company = company;
        this.name = customerName;
        this.iban = iban;
        this.kvk = kvk;
        this.id = new CustomerId(id);
    }

    // for test purposes only (Mock setup)
    public Customer(String customerName, String iban, int kvk, long id){
        this.name = customerName;
        this.iban = iban;
        this.kvk = kvk;
        this.id = new CustomerId(id);
    }


    public void processCompanyCode(String code, UserService service, CustomerRepository repo) throws Exception {
        if(repo.findByCompany(code) != null){
            throw new DupeException("companyCode match found");
        }
        if(service.getCompanyByCode(code) == null){
            throw new NotFoundException();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        if(company != null){
            sb.append(", company=").append(company.getName());
        }
        sb.append(", name='").append(name).append('\'');
        sb.append(", iban='").append(iban).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", kvk=").append(kvk);
        sb.append(", users=").append(users);
        sb.append('}');
        return sb.toString();
    }
}
