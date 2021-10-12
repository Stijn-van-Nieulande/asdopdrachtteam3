package nl.hu.asd.team3.company.adapter;

import nl.hu.asd.team3.company.domain.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyRESTService
{
    public Company findByCode(final Long companyCode)
    {
        return new Company();
    }
}
