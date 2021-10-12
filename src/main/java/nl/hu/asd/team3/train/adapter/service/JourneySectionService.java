package nl.hu.asd.team3.train.adapter.service;

import nl.hu.asd.team3.company.adapter.LocationRESTService;
import nl.hu.asd.team3.company.domain.Location;
import nl.hu.asd.team3.user.adapter.SecurityContext;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JourneySectionService {
    private final LocationRESTService locationRESTService;
    private final SecurityContext securityContext;

    public JourneySectionService(LocationRESTService locationRESTService, SecurityContext securityContext) {
        this.locationRESTService = locationRESTService;
        this.securityContext = securityContext;
    }

    public long getCustomerId() {
        return this.securityContext.getCustomerId();
    }

    public Optional<Location> findByLocationPrimaryCode(String locationId) {
        return this.locationRESTService.findLocationPrimaryCode(locationId);
    }
}
