package app.homework_spring.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(schema = "Customers")
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    private String fullName;
    private Integer ordersCount;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coupon> coupons;
}
