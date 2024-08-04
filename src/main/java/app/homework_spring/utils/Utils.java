package app.homework_spring.utils;

import app.homework_spring.DTO.CustomerDTO;
import app.homework_spring.DTO.DishDTO;
import app.homework_spring.entities.Customer;
import app.homework_spring.entities.Dish;

public class Utils {
    public static Customer toCustomer(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setFullName(dto.getFullName());
        return customer;
    }

    public static Dish toDish(DishDTO dto) {
        Dish dish = new Dish();
        dish.setName(dto.getName());
        dish.setPrice(dto.getPrice());
        dish.setWeight(dto.getWeight());
        return dish;
    }
}
