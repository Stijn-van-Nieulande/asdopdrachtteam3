package nl.hu.asd.team3.train.adapter.service;

import nl.hu.asd.team3.train.application.JourneySectionApplicationService;
import nl.hu.asd.team3.train.domain.JourneySection;
import nl.hu.asd.team3.train.domain.JourneySectionDTO;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JourneySectionRESTService {
    private final JourneySectionApplicationService journeySectionApplicationService;

    public JourneySectionRESTService(JourneySectionApplicationService journeySectionApplicationService) {
        this.journeySectionApplicationService = journeySectionApplicationService;
    }

    public JourneySection updateJourneySection(Long journeySectionId, JourneySectionDTO dto){
        return journeySectionApplicationService.updateJourneySection(journeySectionId, dto);
    }
}
