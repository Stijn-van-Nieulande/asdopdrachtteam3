package nl.hu.asd.team3.user.adapter.repository;

import nl.hu.asd.team3.user.domain.Customer;
import nl.hu.asd.team3.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//@Author Huib van Steenpaal

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findByCompany(String code);

    Customer findByKvK(int kvk);
}
