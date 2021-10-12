package nl.hu.asd.team3;

import nl.hu.asd.team3.company.domain.Location;
import nl.hu.asd.team3.train.adapter.repository.ActivityRepository;
import nl.hu.asd.team3.train.adapter.repository.JourneySectionRepository;
import nl.hu.asd.team3.train.adapter.service.JourneySectionRESTService;
import nl.hu.asd.team3.train.adapter.service.JourneySectionService;
import nl.hu.asd.team3.train.application.JourneySectionApplicationService;
import nl.hu.asd.team3.train.domain.Activity;
import nl.hu.asd.team3.train.domain.JourneySection;
import nl.hu.asd.team3.train.domain.JourneySectionDTO;
import nl.hu.asd.team3.user.adapter.SecurityContext;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class updateJourneySectionTest {

    private JourneySectionRESTService journeySectionRESTService;
    private SecurityContext securityContext;
    private JourneySectionRepository journeySectionRepository;
    private ActivityRepository activityRepository;
    private JourneySectionApplicationService journeySectionApplicationService;
    private JourneySectionService journeySectionService;

    @BeforeEach
    public void init() {
        this.securityContext = mock(SecurityContext.class);
        this.journeySectionRepository = mock(JourneySectionRepository.class);
        this.activityRepository = mock(ActivityRepository.class);
        this.journeySectionService = mock(JourneySectionService.class);
        this.journeySectionApplicationService = new JourneySectionApplicationService(this.securityContext, this.journeySectionRepository);
        this.journeySectionRESTService = new JourneySectionRESTService(this.journeySectionApplicationService);
    }

    @Test
    @DisplayName("bkjabkjjka")
    public void updateJourneySection() {
        Long journeySectionId = 1111L;
        Long customerId = 2222L;
        String locationOriginId = "orgin_id";
        String locationDestinationId = "destination_id";

        JourneySectionDTO dto = new JourneySectionDTO();
        dto.getActivities().add("activity_1");
        dto.getActivities().add("activity_2");

        when(this.journeySectionService.findByLocationPrimaryCode(locationOriginId)).thenReturn(Optional.of(new Location()));
        when(this.journeySectionService.findByLocationPrimaryCode(locationDestinationId)).thenReturn(Optional.of(new Location()));

        JourneySection journeySection = new JourneySection(this.activityRepository, this.journeySectionService, locationOriginId, locationDestinationId, customerId);

        when(this.securityContext.getCustomerId()).thenReturn(customerId);
        when(this.journeySectionRepository.findByIdAndCustomerId(journeySectionId, customerId))
                .thenReturn(Optional.of(journeySection));
        when(this.activityRepository.findById(Mockito.anyString())).thenReturn(Optional.of(new Activity()));
        when(this.journeySectionRepository.save(Mockito.any(JourneySection.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArguments()[0]);

        JourneySection resultJourneySection = this.journeySectionRESTService.updateJourneySection(journeySectionId, dto);
        System.out.println(resultJourneySection);
        Assertions.assertNotNull(resultJourneySection);
    }
}
