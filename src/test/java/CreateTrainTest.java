import nl.hu.asd.team3.company.adapter.CompanyRESTService;
import nl.hu.asd.team3.company.adapter.LocationRESTService;
import nl.hu.asd.team3.company.domain.Company;
import nl.hu.asd.team3.company.domain.Location;
import nl.hu.asd.team3.train.adapter.repository.TrainRepository;
import nl.hu.asd.team3.train.adapter.service.TrainRESTService;
import nl.hu.asd.team3.train.application.TrainApplicationService;
import nl.hu.asd.team3.train.domain.Train;
import nl.hu.asd.team3.train.domain.dto.TrainDTO;
import nl.hu.asd.team3.user.adapter.SecurityContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.mockito.Mockito.*;

public class CreateTrainTest {
    private TrainDTO testDTO;
    private static TrainRepository mockRepo;
    private static CompanyRESTService mockCompany;
    private static TrainRESTService trainRESTService;
    private static LocationRESTService mockLocation;
    private static SecurityContext mockSecurity;

    @BeforeEach
    public void beforeEach() throws Exception {
        mockRepo = mock(TrainRepository.class);

        mockLocation = mock(LocationRESTService.class);
        when(mockLocation.getLocationById(84022845L)).thenReturn(new Location(52.0493445F,5.1158965F));
        mockSecurity = mock(SecurityContext.class);
        when(mockSecurity.getCustomerId()).thenReturn(345123L);
        mockCompany = mock(CompanyRESTService.class);
        when(mockCompany.findRecipientByCode("TCO")).thenReturn(new Company("TestCorp"));
        when(mockCompany.findRecipientByCode("NTCO")).thenReturn(null);

        trainRESTService = new TrainRESTService(new TrainApplicationService(mockRepo));
    }

    @DisplayName("create a train where a recipient exists")
    @Test
    public void createTrainWithRecipient(){

        testDTO = new TrainDTO();
        testDTO.trainType = 2;
        testDTO.operationalTrainNumber = "123FG6";
        testDTO.scheduledTimeAtHandover = new Date(279838123);
        testDTO.scheduledDateTimeAtTransfer = new Date(1279838123);

        testDTO.companyCode = "TCO";
        testDTO.locationId = 84022845L;

        Train train = trainRESTService.createTrain(testDTO, mockLocation, mockCompany, mockSecurity);
        System.out.println(train);
        Assertions.assertNotNull(train);
    }

    @DisplayName("create a train where a recipient does not exist")
    @Test
    public void createTrainWithoutRecipient(){

        testDTO = new TrainDTO();
        testDTO.trainType = 2;
        testDTO.operationalTrainNumber = "123FG6";
        testDTO.scheduledTimeAtHandover = new Date(279838123);
        testDTO.scheduledDateTimeAtTransfer = new Date(1279838123);

        testDTO.companyCode = "NTCO";
        testDTO.locationId = 84022845L;

        Train train = trainRESTService.createTrain(testDTO, mockLocation, mockCompany, mockSecurity);
        System.out.println(train);
        Assertions.assertNotNull(train);
    }
}
