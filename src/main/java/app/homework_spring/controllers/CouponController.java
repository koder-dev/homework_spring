package app.homework_spring.controllers;

import app.homework_spring.DTO.CouponDTO;
import app.homework_spring.exceptions.CustomerNotFoundException;
import app.homework_spring.services.CouponService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static app.homework_spring.utils.ResponseStringConstants.*;

@RestController
@RequestMapping("/coupons")
public class CouponController {
    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping
    public ResponseEntity<String> addCoupon(@RequestBody CouponDTO couponDTO) {
        try {
            return ResponseEntity.ok(couponService.addCoupon(couponDTO).toString());
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_POST + " " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_POST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCoupon(@PathVariable Long id) {
        try {
            couponService.delete(id);
            return ResponseEntity.ok(RESPONSE_OK_DELETE);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_DELETE);
        }
    }

}
