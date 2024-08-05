package app.homework_spring.controllers;

import app.homework_spring.DTO.DishDTO;
import app.homework_spring.exceptions.DishAlreadyExistException;
import app.homework_spring.services.DishService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static app.homework_spring.utils.ResponseStringConstants.*;

@RestController
@RequestMapping("/dishes")
public class DishController {
    private final DishService dishService;
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping
    public ResponseEntity<String> addDish(@RequestBody DishDTO dishDTO) {
        try {
            return ResponseEntity.ok(dishService.add(dishDTO).toString());
        } catch (DishAlreadyExistException e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_POST + " " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_POST);
        }
    }

}
