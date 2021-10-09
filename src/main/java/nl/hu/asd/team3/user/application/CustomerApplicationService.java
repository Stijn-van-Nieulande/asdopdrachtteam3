package nl.hu.asd.team3.user.application;

import nl.hu.asd.team3.user.adapter.repository.CustomerRepository;
import nl.hu.asd.team3.user.adapter.service.UserService;
import nl.hu.asd.team3.user.domain.Customer;
import nl.hu.asd.team3.user.domain.dto.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public class CustomerApplicationService {
    private final CustomerRepository repository;
    private final UserService service;

    public CustomerApplicationService(CustomerRepository repository, UserService service) {
        this.repository = repository;
        this.service = service;
    }

    public Customer createCustomer(CustomerDTO dto) {
        Customer c;
        if(dto.getCompanyCode() == null || !dto.getCompanyCode().equals("")){
             c = new Customer(service, dto.getCompanyCode(), dto.getCustomername(), dto.getIban(), dto.getKvk());
        }
        else{
             c = new Customer(dto.getCustomername(), dto.getIban(), dto.getKvk());
        }
        if(!c.checkDuplicate()){
            return repository.save(c);
        }
        return c;
    }
}
