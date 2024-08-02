package app.homework_spring.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customers", schema = "public")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private Integer ordersCount;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coupon> coupons;

    // Constructor
    public Customer() {}

    public Customer(String fullName, Integer ordersCount, List<Coupon> coupons) {
        this.fullName = fullName;
        this.ordersCount = ordersCount;
        this.coupons = coupons;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(Integer ordersCount) {
        this.ordersCount = ordersCount;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", ordersCount=" + ordersCount +
                ", coupons=" + coupons +
                '}';
    }
}
