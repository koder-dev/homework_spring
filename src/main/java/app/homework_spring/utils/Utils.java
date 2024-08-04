package app.homework_spring.utils;

import app.homework_spring.DTO.CustomerDTO;
import app.homework_spring.entities.Customer;

public class Utils {
    public static Customer toCustomer(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setFullName(dto.getFullName());
        return customer;
    }
}
