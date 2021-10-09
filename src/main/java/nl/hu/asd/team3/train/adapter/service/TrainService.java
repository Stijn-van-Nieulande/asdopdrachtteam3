package nl.hu.asd.team3.train.adapter.service;

import nl.hu.asd.team3.company.adapter.CompanyRESTService;
import nl.hu.asd.team3.company.adapter.LocationRESTService;
import nl.hu.asd.team3.user.adapter.SecurityContext;

public class TrainService {
    public Long getCustomerId() {
        return SecurityContext.getCustomerId();
    }

    public Object findRecipientByCode(String companyCode){
        return CompanyRESTService.findRecipientByCode(companyCode);
    }

    public Object getLocation(Long locationId){
        return LocationRESTService.getLocationById(locationId);
    }
}
