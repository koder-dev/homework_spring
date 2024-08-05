package app.homework_spring.services;

import app.homework_spring.DTO.DishDTO;
import app.homework_spring.entities.Dish;
import app.homework_spring.exceptions.DishAlreadyExistException;
import app.homework_spring.repositories.DishRepo;
import app.homework_spring.utils.Utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DishService {

    private final DishRepo dishRepo;
    private final EntityManager entityManager;

    @Autowired
    public DishService(DishRepo dishRepo, EntityManager entityManager) {
        this.dishRepo = dishRepo;
        this.entityManager = entityManager;
    }

    public Dish add(DishDTO dishDTO) throws DishAlreadyExistException {
        Dish dish = Utils.toDish(dishDTO);
        if(dishRepo.findByNameAndAndWeight(dish.getName(), dish.getWeight()).isEmpty()) {
           return dishRepo.save(dish);
        }
        throw new DishAlreadyExistException();
    }

    public List<Dish> get(Double fromPrice, Double toPrice, Integer totalWeight) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Dish> cq = cb.createQuery(Dish.class);
        Root<Dish> root = cq.from(Dish.class);
        List<Predicate> predicates = new ArrayList<>();

        if(Objects.nonNull(fromPrice)) predicates.add(cb.greaterThanOrEqualTo(root.get("price"), fromPrice));
        if(Objects.nonNull(toPrice)) predicates.add(cb.lessThanOrEqualTo(root.get("price"), toPrice));
        cq.select(root)
                .where(cb.and(predicates.toArray(new Predicate[0])));

        TypedQuery<Dish> typedQuery = entityManager.createQuery(cq);
        if (Objects.isNull(totalWeight)) {
            return typedQuery.getResultList();
        }
        AtomicInteger currentWeight = new AtomicInteger();
        return typedQuery.getResultStream().dropWhile(dish -> {
            currentWeight.addAndGet(dish.getWeight());
            return currentWeight.get() >= totalWeight;
        }).toList();

    }
}
