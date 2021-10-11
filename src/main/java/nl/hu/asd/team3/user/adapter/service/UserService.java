package nl.hu.asd.team3.user.adapter.service;

import nl.hu.asd.team3.company.adapter.service.CompanyRESTService;
import nl.hu.asd.team3.company.domain.Company;
//@Author Huib van Steenpaal


public class UserService {
    public Company getCompanyByCode(String companyCode) {
        return CompanyRESTService.getByCompanyCode(companyCode);
    }
}
