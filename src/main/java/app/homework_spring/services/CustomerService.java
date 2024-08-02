package app.homework_spring.services;

import app.homework_spring.entities.Customer;
import app.homework_spring.exceptions.CustomerAlreadyExistException;
import app.homework_spring.repositories.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Long save(Customer customer) throws CustomerAlreadyExistException {
        if (Objects.isNull(customerRepo.findByFullName(customer.getFullName()))) {
            return customerRepo.save(customer).getId();
        }
        throw new CustomerAlreadyExistException("Customer with this name already exist");
    }

    public Customer update(Customer customer) {
        Optional<Customer> foundCustomer = customerRepo.findById(customer.getId());
        if (foundCustomer.isPresent()) {
            
        }
    }
}
