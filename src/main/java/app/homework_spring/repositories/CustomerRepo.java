package app.homework_spring.repositories;

import app.homework_spring.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Long> {
    public Customer findByFullName(String fullName);
}
