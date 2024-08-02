package app.homework_spring.controllers;


import app.homework_spring.entities.Customer;
import app.homework_spring.exceptions.CustomerAlreadyExistException;
import app.homework_spring.repositories.CustomerRepo;
import app.homework_spring.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    public final String RESPONSE_OK_TEXT = "Server working!";
    public final String RESPONSE_OK_POST = "Customer created!";
    public final String RESPONSE_OK_PUT = "Customer updated!";
    public final String RESPONSE_OK_DELETE = "Customer deleted!";
    public final String BAD_REQUEST_TEXT = "Bad request!";
    public final String BAD_REQUEST_POST = "Bad post request!";
    public final String BAD_REQUEST_PUT = "Bad put request!";
    public final String BAD_REQUEST_DELETE = "Bad delete request!";

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity getCustomers() {
        try {
            return ResponseEntity.ok(RESPONSE_OK_TEXT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_TEXT + " " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody Customer customer) {
        try {
            customerService.save(customer);
            return ResponseEntity.ok(RESPONSE_OK_POST);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_POST + " " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody Customer customer) {
        try {
            return ResponseEntity.ok(RESPONSE_OK_PUT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_PUT + " " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity deleteCustomer(@RequestBody Long id) {
        try {
            return ResponseEntity.ok(RESPONSE_OK_DELETE);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_DELETE + " " + e.getMessage());
        }
    }
}
