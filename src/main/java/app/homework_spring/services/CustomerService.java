package app.homework_spring.services;

import app.homework_spring.DTO.CustomerDTO;
import app.homework_spring.entities.Customer;
import app.homework_spring.exceptions.CustomerAlreadyExistException;
import app.homework_spring.exceptions.CustomerNotFoundException;
import app.homework_spring.repositories.CustomerRepo;
import app.homework_spring.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepo.findAll().stream().map(CustomerDTO::new).toList();
    }

    public CustomerDTO findCustomerById(Long id) throws CustomerNotFoundException {
        return new CustomerDTO(customerRepo.findById(id).orElseThrow(CustomerNotFoundException::new));
    }

    public Long save(CustomerDTO dto) throws CustomerAlreadyExistException {
        Customer customer = Utils.toCustomer(dto);
        if (customerRepo.findByFullName(customer.getFullName()).isEmpty()) {
            return customerRepo.save(customer).getId();
        }
        throw new CustomerAlreadyExistException("Customer with this name already exist");
    }

    public void update(Long id, CustomerDTO dto) throws CustomerNotFoundException {
        Customer foundCustomer = customerRepo.findById(id).orElseThrow(CustomerNotFoundException::new);
        Customer customer = Utils.toCustomer(dto);
        customer.setFullName(foundCustomer.getFullName());
        customerRepo.save(customer);
    }

    public void delete(Long id) {
        customerRepo.deleteById(id);
    }
}
