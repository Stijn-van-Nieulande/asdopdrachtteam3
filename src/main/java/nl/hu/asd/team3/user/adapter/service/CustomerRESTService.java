package nl.hu.asd.team3.user.adapter.service;

import nl.hu.asd.team3.user.application.CustomerApplicationService;
import nl.hu.asd.team3.user.dto.CustomerDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerRESTService {
    private final CustomerApplicationService applicationService;

    public CustomerRESTService(CustomerApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    public void createCustomer(@Validated @RequestBody CustomerDTO customerDTO){
        applicationService.createCustomer(customerDTO);
    }
}
