package nl.hu.asd.team3.train.adapter.service;

import nl.hu.asd.team3.company.adapter.CompanyRESTService;
import nl.hu.asd.team3.company.adapter.LocationRESTService;
import nl.hu.asd.team3.company.domain.Company;
import nl.hu.asd.team3.company.domain.Location;
import nl.hu.asd.team3.user.adapter.SecurityContext;
import org.springframework.stereotype.Service;

@Service
public class TrainService {
    private CompanyRESTService companyRESTService;
    private LocationRESTService locationRESTService;
    private SecurityContext securityContext;

    public TrainService(CompanyRESTService companyRESTService, LocationRESTService locationRESTService, SecurityContext securityContext) {
        this.companyRESTService = companyRESTService;
        this.locationRESTService = locationRESTService;
        this.securityContext = securityContext;
    }

    public Long getCustomerId() {
        return this.securityContext.getCustomerId();
    }

    public  Company findRecipientByCode(String companyCode){
        return this.companyRESTService.findRecipientByCode(companyCode);
    }

    public  Location getLocation(Long locationId){
        return this.locationRESTService.getLocationById(locationId);
    }
}
