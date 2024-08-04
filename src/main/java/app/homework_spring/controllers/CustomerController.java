package app.homework_spring.controllers;


import app.homework_spring.DTO.CustomerDTO;
import app.homework_spring.exceptions.CustomerAlreadyExistException;
import app.homework_spring.exceptions.CustomerNotFoundException;
import app.homework_spring.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static app.homework_spring.utils.ResponseStringConstants.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }



    @GetMapping
    public ResponseEntity<String> getCustomers() {
        try {
            return ResponseEntity.ok(customerService.getAllCustomers().toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_GET);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getCustomer(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(customerService.findCustomerById(id).toString());
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_GET + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_POST);
        }
    }

    @PostMapping
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerDTO dto) {
        try {
            Long id = customerService.save(dto);
            return ResponseEntity.ok(RESPONSE_OK_POST + id);
        } catch (CustomerAlreadyExistException e) {
            return ResponseEntity.badRequest().body(RESPONSE_OK_POST + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_POST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO dto) {
        try {
            customerService.update(id, dto);
            return ResponseEntity.ok(RESPONSE_OK_PUT);
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.badRequest().body(RESPONSE_OK_PUT + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_PUT);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCustomer(@RequestBody Long id) {
        try {
            customerService.delete(id);
            return ResponseEntity.ok(RESPONSE_OK_DELETE);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_DELETE + " " + e.getMessage());
        }
    }
}
