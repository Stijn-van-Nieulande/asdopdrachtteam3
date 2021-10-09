import nl.hu.asd.team3.company.domain.Company;
import nl.hu.asd.team3.user.adapter.repository.CustomerRepository;
import nl.hu.asd.team3.user.adapter.service.CustomerRESTService;
import nl.hu.asd.team3.user.adapter.service.UserService;
import nl.hu.asd.team3.user.application.CustomerApplicationService;
import nl.hu.asd.team3.user.domain.Customer;
import nl.hu.asd.team3.user.domain.dto.CustomerDTO;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertNotNull;

public class CreateCustomerTest {
    private CustomerDTO dtoWithCode;
    private CustomerDTO dtoNoCode;
    private static CustomerRepository mockedRepo;
    private static UserService mockedService;
    private static CustomerRESTService restService;


    @BeforeClass
    public static void beforeClass() throws Exception {
        mockedRepo = mock(CustomerRepository.class);

        mockedService = mock(UserService.class);
        when(mockedService.getCompanyByCode("42069")).thenReturn(new Company("anCorp"));

        restService = new CustomerRESTService(new CustomerApplicationService(mockedRepo, mockedService));
    }

    @Test
    public void createCustomerWithoutCode(){
        dtoNoCode = new CustomerDTO();
        dtoNoCode.setCustomername("ankh");
        dtoNoCode.setIban("z0n3");
        dtoNoCode.setKvk(34);

        Customer customer = new Customer("ankh", "z0n3", 34);

        when(mockedRepo.save(customer)).thenReturn(customer);

        System.out.println(restService.createCustomer(dtoNoCode));

        assertNotNull(restService.createCustomer(dtoNoCode));
    }

    @Test
    public void createCustomerWithCode(){
        dtoWithCode = new CustomerDTO();
        dtoWithCode.setCompanyCode("42069");
        dtoWithCode.setCustomername("ankh");
        dtoWithCode.setIban("z0n3");
        dtoWithCode.setKvk(34);

        Customer customer = new Customer(mockedService, "42069", "ankh", "z0n3", 34);

        when(mockedRepo.save(customer)).thenReturn(customer);

        System.out.println(restService.createCustomer(dtoWithCode));

        assertNotNull(restService.createCustomer(dtoWithCode));
    }
}
