package nl.hu.asd.team3.user.application;

import nl.hu.asd.team3.user.adapter.repository.CustomerRepository;
import nl.hu.asd.team3.user.domain.Customer;
import nl.hu.asd.team3.user.dto.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public class CustomerApplicationService {
    private final CustomerRepository customerRepository;

    public CustomerApplicationService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CustomerDTO dto) {
        Customer c;
        if(!dto.getCompanyCode().equals("")){
             c = new Customer(dto.getCompanyCode(), dto.getCustomername(), dto.getIban(), dto.getKvk());
        }
        else{
             c = new Customer(dto.getCustomername(), dto.getIban(), dto.getKvk());
        }
        if(c.checkDuplicate()){
            return customerRepository.save(c);
        }
        return c;
    }
}
