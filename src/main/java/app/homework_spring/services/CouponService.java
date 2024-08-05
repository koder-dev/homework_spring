package app.homework_spring.services;

import app.homework_spring.DTO.CouponDTO;
import app.homework_spring.entities.Coupon;
import app.homework_spring.entities.Customer;
import app.homework_spring.exceptions.CustomerNotFoundException;
import app.homework_spring.repositories.CouponRepo;
import app.homework_spring.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CouponService {
    private CouponRepo couponRepo;
    private CustomerRepo customerRepo;

    @Autowired
    public CouponService(CouponRepo couponRepo, CustomerRepo customerRepo) {
        this.couponRepo = couponRepo;
        this.customerRepo = customerRepo;
    }


    public CouponService() {}

    @Transactional
    public Coupon addCoupon(CouponDTO couponDTO) throws CustomerNotFoundException {
        Customer customer = customerRepo.findByFullName(couponDTO.getCustomerName()).orElseThrow(CustomerNotFoundException::new);
        Coupon coupon = new Coupon();
        coupon.setCustomer(customer);
        coupon.setDiscount(couponDTO.getCouponDiscount());
        return couponRepo.save(coupon);
    }

    public void delete(Long id) {
        couponRepo.deleteById(id);
    }
}
