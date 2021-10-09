package nl.hu.asd.team3.user.adapter.service;

import nl.hu.asd.team3.user.adapter.repository.CustomerRepository;
import nl.hu.asd.team3.user.application.CustomerApplicationService;
import nl.hu.asd.team3.user.dto.CustomerDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerRESTServiceTest {

    @BeforeEach
    void setUp() {
        CustomerRESTService = new CustomerRESTService(new CustomerApplicationService());
        
        CustomerDTO dto = new CustomerDTO();
        dto.setCompanyCode("42069");
        dto.setCustomername("HR solutions");
        dto.setIban("idk123");
        dto.setKvk(21);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createCustomerWithCode() {
        
    }
}