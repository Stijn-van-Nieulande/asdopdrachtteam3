package nl.hu.asd.team3.user.adapter.service;

import nl.hu.asd.team3.user.application.CustomerApplicationService;
import nl.hu.asd.team3.user.domain.Customer;
import nl.hu.asd.team3.user.domain.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerRESTService {
    private final CustomerApplicationService applicationService;

    public CustomerRESTService(CustomerApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    public Customer createCustomer(CustomerDTO customerDTO){
        return applicationService.createCustomer(customerDTO);
    }
}
