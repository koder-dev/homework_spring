package app.homework_spring.controllers;

import app.homework_spring.DTO.OrderDTO;
import app.homework_spring.entities.Order;
import app.homework_spring.exceptions.CustomerNotFoundException;
import app.homework_spring.exceptions.DishNotFoundException;
import app.homework_spring.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private OrderService orderService;
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> makeNewOrder(@RequestBody OrderDTO orderDTO) {
        try {
            return ResponseEntity.ok(orderService.makeNewOrder(orderDTO));
        } catch (CustomerNotFoundException | DishNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
