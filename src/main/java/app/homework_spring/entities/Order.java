package app.homework_spring.entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Orders", schema = "public")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Dish> dishes;

    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private Double totalPrice;

    @OneToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @PrePersist
    @PreUpdate
    public void calculateTotalPrice() {
        totalPrice = dishes.stream().mapToDouble(Dish::getPrice).sum();
        if (coupon != null) {
            totalPrice -= totalPrice * coupon.getDiscount();
        }
    }

    // Constructor
    public Order() {}

    public Order(List<Dish> dishes, String status, Customer customer, Coupon coupon) {
        this.dishes = dishes;
        this.status = status;
        this.customer = customer;
        this.coupon = coupon;
        calculateTotalPrice();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
