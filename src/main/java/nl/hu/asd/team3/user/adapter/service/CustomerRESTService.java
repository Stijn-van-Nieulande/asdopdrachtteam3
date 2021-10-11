package nl.hu.asd.team3.user.adapter.service;

import nl.hu.asd.team3.user.application.CustomerApplicationService;
import nl.hu.asd.team3.user.domain.Customer;
import nl.hu.asd.team3.user.domain.dto.CustomerDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
//@Author Huib van Steenpaal


@RestController
public class CustomerRESTService {
    private final CustomerApplicationService applicationService;

    public CustomerRESTService(@Validated @RequestBody CustomerApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    public Object createCustomer(CustomerDTO customerDTO) {
        try {
            return applicationService.createCustomer(customerDTO);
        }catch (Exception e){
            return e;
        }
    }
}
