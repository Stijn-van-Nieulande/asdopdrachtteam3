package nl.hu.asd.team3.user.adapter.repository;

import nl.hu.asd.team3.user.domain.Customer;
import nl.hu.asd.team3.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    User findByCompany();

    User findByKvK();
}
