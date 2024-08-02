package app.homework_spring.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(schema = "Orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Dish> dishes;

    private String status;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    private Customer customer;

    private Double totalPrice;

    @OneToOne
    private Coupon coupon;

    @PrePersist
    @PreUpdate
    public void calculateTotalPrice() {
        totalPrice = dishes.stream().mapToDouble(Dish::getPrice).sum();
        if (Objects.nonNull(coupon)) totalPrice -= totalPrice * coupon.getDiscount();
    }

    public Order(List<Dish> dishes, String status, Customer customer, double totalPrice) {
        this.dishes = dishes;
        this.status = status;
        this.customer = customer;
        this.totalPrice = totalPrice;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dishes=" + dishes +
                ", status='" + status + '\'' +
                ", customer=" + customer +
                ", totalPrice=" + totalPrice +
                ", coupon=" + coupon +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Long getId() {
        return id;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Coupon getCoupon() {
        return coupon;
    }
}
