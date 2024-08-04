package app.homework_spring.repositories;

import app.homework_spring.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface CustomerRepo extends CrudRepository<Customer, Long> {
    Optional<Customer> findByFullName(String fullName);

    @Override
    List<Customer> findAll();
}
