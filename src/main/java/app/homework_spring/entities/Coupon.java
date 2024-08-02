package app.homework_spring.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(schema = "Coupons")
public class Coupon {

    @Id
    @GeneratedValue
    private Long id;

    private Double discount;
    private Date expireDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", discount=" + discount +
                ", expireDate=" + expireDate +
                ", customer=" + customer +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public double getDiscount() {
        return discount;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Coupon() {
    }

    public Coupon(Long id, double discount, Date expireDate, Customer customer) {
        this.id = id;
        this.discount = discount;
        this.expireDate = expireDate;
        this.customer = customer;
    }
}
