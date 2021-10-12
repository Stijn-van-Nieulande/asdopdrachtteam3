package nl.hu.asd.team3.train.application;

import nl.hu.asd.team3.train.adapter.repository.JourneySectionRepository;
import nl.hu.asd.team3.train.domain.JourneySection;
import nl.hu.asd.team3.train.domain.JourneySectionDTO;
import nl.hu.asd.team3.user.adapter.SecurityContext;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;

@Repository
public class JourneySectionApplicationService {
    private final SecurityContext securityContext;
    private final JourneySectionRepository journeySectionRepository;

    public JourneySectionApplicationService(SecurityContext securityContext, JourneySectionRepository journeySectionRepository) {
        this.securityContext = securityContext;
        this.journeySectionRepository = journeySectionRepository;
    }

    public JourneySection updateJourneySection(Long journeySectionId, JourneySectionDTO dto) {
        Long customerId = securityContext.getCustomerId();
        JourneySection journeySection = journeySectionRepository.findByIdAndCustomerId(journeySectionId, customerId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Could not find journey section with id %d", journeySectionId)));
        journeySection.update(dto);
        return journeySectionRepository.save(journeySection);
    }
}
