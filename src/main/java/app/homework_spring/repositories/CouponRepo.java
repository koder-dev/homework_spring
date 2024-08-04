package app.homework_spring.repositories;

import app.homework_spring.entities.Coupon;
import org.springframework.data.repository.CrudRepository;

public interface CouponRepo extends CrudRepository<Coupon, Long> {
}
