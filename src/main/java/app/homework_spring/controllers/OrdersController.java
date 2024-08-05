package app.homework_spring.controllers;

import app.homework_spring.DTO.OrderDTO;
import app.homework_spring.exceptions.CustomerNotFoundException;
import app.homework_spring.exceptions.DishNotFoundException;
import app.homework_spring.services.OrderService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import static app.homework_spring.utils.ResponseStringConstants.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrderService orderService;
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> makeNewOrder(@RequestBody OrderDTO orderDTO) {
        try {
            return ResponseEntity.ok(orderService.makeNewOrder(orderDTO).toString());
        } catch (CustomerNotFoundException | DishNotFoundException e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_POST + " " + e.getMessage());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(DUPLICATE_ENTITY_USAGE + " " + e.getMessage());
        }
    }
}
