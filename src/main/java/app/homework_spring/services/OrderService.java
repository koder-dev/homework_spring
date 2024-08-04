package app.homework_spring.services;

import app.homework_spring.DTO.OrderDTO;
import app.homework_spring.entities.Coupon;
import app.homework_spring.entities.Customer;
import app.homework_spring.entities.Dish;
import app.homework_spring.entities.Order;
import app.homework_spring.exceptions.CustomerNotFoundException;
import app.homework_spring.exceptions.DishNotFoundException;
import app.homework_spring.repositories.CouponRepo;
import app.homework_spring.repositories.CustomerRepo;
import app.homework_spring.repositories.DishRepo;
import app.homework_spring.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepo orderRepo;
    private DishRepo dishRepo;
    private CustomerRepo customerRepo;
    private CouponRepo couponRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo, DishRepo dishRepo, CustomerRepo customerRepo, CouponRepo couponRepo) {
        this.dishRepo = dishRepo;
        this.customerRepo = customerRepo;
        this.orderRepo = orderRepo;
        this.couponRepo = couponRepo;
    }

    public Order makeNewOrder(OrderDTO dto) throws CustomerNotFoundException, DishNotFoundException {
        Customer customer = customerRepo.findByFullName(dto.getCustomerName()).orElseThrow(CustomerNotFoundException::new);
        List<Dish> dishes = new ArrayList<>();
        List<String> notFoundDishes = new ArrayList<>();
        dto.getDishesName().stream().forEach(dishName -> {
            Optional<Dish> optDish = dishRepo.findByName(dishName);
            optDish.ifPresentOrElse(dishes::add, () -> notFoundDishes.add(dishName));
        });
        if (!notFoundDishes.isEmpty()) {
            throw new DishNotFoundException("This dishes not found in the database: " + notFoundDishes.toString());
        }
        Order order = new Order();
        if (dto.getCouponId() > 0) {
            couponRepo.findById(dto.getCouponId()).ifPresent(order::setCoupon);
        }
        order.setCustomer(customer);
        order.setDishes(dishes);
        return orderRepo.save(order);
    }
}
