package nl.hu.asd.team3.user.application;

import nl.hu.asd.team3.user.adapter.repository.CustomerRepository;
import nl.hu.asd.team3.user.adapter.service.UserService;
import nl.hu.asd.team3.user.domain.Customer;
import nl.hu.asd.team3.user.domain.dto.CustomerDTO;
import org.springframework.stereotype.Service;
//@Author Huib van Steenpaal


@Service
public class CustomerApplicationService {
    private final CustomerRepository repository;

    private final UserService service;

    public CustomerApplicationService(CustomerRepository repository, UserService service) {
        this.repository = repository;
        this.service = service;
    }

    public Customer createCustomer(CustomerDTO dto) throws Exception {
        Customer c;

        if(dto.getCompanyCode() != null) {
            System.out.println("code given");
            c = new Customer(service, repository, dto.getCompanyCode(), dto.getCustomername(), dto.getIban(), dto.getKvk(), dto.getId());
        }
        else {
            System.out.println("no code given");
            c = new Customer(repository, dto.getCustomername(), dto.getIban(), dto.getKvk(), dto.getId());
        }
        repository.save(c);
        return c;
    }
}
