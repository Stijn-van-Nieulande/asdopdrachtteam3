package nl.hu.asd.team3.user.adapter.service;

import nl.hu.asd.team3.company.adapter.service.CompanyRESTService;

public class UserService {
    public static Object getCompanyByCode(String companyCode) {
        return CompanyRESTService.getByCompanyCode(companyCode);
    }
}
