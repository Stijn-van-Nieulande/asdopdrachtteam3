package nl.hu.asd.team3;

import nl.hu.asd.team3.company.adapter.CompanyRESTService;
import nl.hu.asd.team3.company.domain.Company;
import nl.hu.asd.team3.company.domain.Location;
import nl.hu.asd.team3.train.adapter.repository.MessageRepository;
import nl.hu.asd.team3.train.adapter.repository.TrainRepository;
import nl.hu.asd.team3.train.application.CiService;
import nl.hu.asd.team3.train.domain.Train;
import nl.hu.asd.team3.train.domain.dto.TrainCompositionMessageDTO;
import nl.hu.asd.team3.user.user.adapter.SecurityContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SendTrainCompositionMessageTest
{
    private CiService ciService;
    private CompanyRESTService companyRESTService;
    private SecurityContext securityContext;
    private TrainRepository trainRepository;
    private MessageRepository messageRepository;

    @BeforeEach
    public void init()
    {
        this.securityContext = mock(SecurityContext.class);
        this.trainRepository = mock(TrainRepository.class);
        this.companyRESTService = mock(CompanyRESTService.class);
        this.messageRepository = mock(MessageRepository.class);
        this.ciService = new CiService(this.securityContext, this.trainRepository);
    }

    @Test
    @DisplayName("Create a train composition message")
    public void createTrainCompositionMessage()
    {
        final Long trainId = 444L;
        final Long customerId = 555L;

        when(this.trainRepository.findByIdAndCustomerId(trainId, customerId)).thenReturn(new Train(
                this.companyRESTService,
                this.messageRepository,
                969696L,
                111,
                "a",
                new Date(),
                new Date(),
                new Location(),
                new Company(),
                969696L
        ));
        when(this.securityContext.getCustomerId()).thenReturn(customerId);
        when(this.trainRepository.save(Mockito.any(Train.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArguments()[0]);

        final TrainCompositionMessageDTO dto = new TrainCompositionMessageDTO(
                "someObjectType",
                96969696L,
                "someCore",
                "someVariant",
                2021,
                trainId,
                customerId,
                3,
                "someSenderReference",
                11,
                "1.9.2",
                "a-fancy-but-not-so-real-identifier",
                new Date()
        );

        final Train train = this.ciService.sendMessageToCi(dto);

        System.out.println(train.getTrainCompositionMessages().stream().map(Object::toString).collect(Collectors.joining(", ")));
        Assertions.assertNotNull(train);
    }
}
