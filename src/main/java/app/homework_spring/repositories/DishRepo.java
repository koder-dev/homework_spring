package app.homework_spring.repositories;

import app.homework_spring.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DishRepo extends JpaRepository<Dish, Integer> {

    Optional<Dish> findByNameAndAndWeight(String name, Integer weight);

    Optional<Dish> findByName(String name);
}
