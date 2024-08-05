package app.homework_spring.services;

import app.homework_spring.DTO.DishDTO;
import app.homework_spring.entities.Dish;
import app.homework_spring.exceptions.DishAlreadyExistException;
import app.homework_spring.repositories.DishRepo;
import app.homework_spring.utils.Utils;
import org.springframework.stereotype.Service;

@Service
public class DishService {

    private final DishRepo dishRepo;
    public DishService(DishRepo dishRepo) {
        this.dishRepo = dishRepo;
    }

    public Dish add(DishDTO dishDTO) throws DishAlreadyExistException {
        Dish dish = Utils.toDish(dishDTO);
        if(dishRepo.findByNameAndAndWeight(dish.getName(), dish.getWeight()).isEmpty()) {
           return dishRepo.save(dish);
        }
        throw new DishAlreadyExistException();
    }
}
