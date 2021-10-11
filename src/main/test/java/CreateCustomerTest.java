import nl.hu.asd.team3.company.domain.Company;
import nl.hu.asd.team3.user.Exception.DupeException;
import nl.hu.asd.team3.user.Exception.NotFoundException;
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

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
//@Author Huib van Steenpaal


public class CreateCustomerTest {
    private CustomerDTO dtoWithCode;
    private CustomerDTO dtoNoCode;
    private static CustomerRepository mockedRepo;
    private static UserService mockedService;
    private static CustomerRESTService restService;


    @BeforeClass
    public static void beforeClass() {
        mockedRepo = mock(CustomerRepository.class);
        mockedService = mock(UserService.class);

        restService = new CustomerRESTService(new CustomerApplicationService(mockedRepo, mockedService));
    }

    @Test
    public void createCustomerWithoutCode(){
        // data voor createCustomer()
        dtoNoCode = new CustomerDTO();
        dtoNoCode.setCustomername("ankh");
        dtoNoCode.setIban("z0n3");
        dtoNoCode.setKvk(37);

        Customer customer = new Customer("test", "l33t", 420);
        when(mockedRepo.findByKvK(420)).thenReturn(customer);

        Customer customerToSave = new Customer( "ankh", "z0n3", 37);
        when(mockedRepo.save(customerToSave)).thenReturn(customerToSave);

        Object response = restService.createCustomer(dtoNoCode);
        System.out.println(response);
        assertTrue(response instanceof Customer);
    }



    @Test
    public void createCustomerWithCode(){
        // data voor createCustomer()
        dtoWithCode = new CustomerDTO();
        dtoWithCode.setCompanyCode("42069");
        dtoWithCode.setCustomername("ankh");
        dtoWithCode.setIban("z0n3");
        dtoWithCode.setKvk(37);

        Company company = new Company("ankhInc", "42069");
        when(mockedService.getCompanyByCode("42069")).thenReturn(company);

        Customer customer = new Customer("test", "l33t", 420);
        when(mockedRepo.findByKvK(420)).thenReturn(customer);

        Customer customerToSave = new Customer(company, "ankh", "z0n3", 37);
        when(mockedRepo.save(customerToSave)).thenReturn(customerToSave);


        Object response = restService.createCustomer(dtoWithCode);
        System.out.println(response);
        assertTrue(response instanceof Customer);
    }

    @Test
    public void checkDupeByKvK(){
        // data voor createCustomer()
        dtoNoCode = new CustomerDTO();
        dtoNoCode.setCustomername("ankh");
        dtoNoCode.setIban("z0n3");
        dtoNoCode.setKvk(34);

        Customer customer = new Customer("ankh", "z0n3", 34);
        when(mockedRepo.save(customer)).thenReturn(customer);
        when(mockedRepo.findByKvK(34)).thenReturn(customer);

        Object response = restService.createCustomer(dtoNoCode);

        System.out.println(response);
        assertTrue(response instanceof DupeException);
        assertEquals("KvK match found", ((DupeException) response).getReason());
    }

    @Test
    public void checkDupeByCode(){
        // data voor createCustomer()
        dtoWithCode = new CustomerDTO();
        dtoWithCode.setCompanyCode("42069");
        dtoWithCode.setCustomername("ankh");
        dtoWithCode.setIban("z0n3");
        dtoWithCode.setKvk(37);

        Company company = new Company("ankhInc", "42069");
        when(mockedService.getCompanyByCode("42069")).thenReturn(company);

        Customer customer = new Customer(company, "ankh", "z0n3", 34);
        when(mockedRepo.save(customer)).thenReturn(customer);
        when(mockedRepo.findByCompany("42069")).thenReturn(customer);


        Object response = restService.createCustomer(dtoWithCode);

        System.out.println(response);
        assertTrue(response instanceof DupeException);
        assertEquals("companyCode match found", ((DupeException) response).getReason());
    }

    @Test
    public void companyDoesntExist(){
        // data voor createCustomer()
        dtoWithCode = new CustomerDTO();
        dtoWithCode.setCompanyCode("42069");
        dtoWithCode.setCustomername("ankh");
        dtoWithCode.setIban("z0n3");
        dtoWithCode.setKvk(37);

        when(mockedRepo.findByCompany("42069")).thenReturn(null);

        Object response = restService.createCustomer(dtoWithCode);

        System.out.println(response);
        assertTrue(response instanceof NotFoundException);
    }
}
