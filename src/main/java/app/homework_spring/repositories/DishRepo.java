package app.homework_spring.repositories;

import app.homework_spring.entities.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DishRepo extends CrudRepository<Dish, Long> {

    Optional<Dish> findByNameAndAndWeight(String name, Integer weight);

    Optional<Dish> findByName(String name);
}
