package app.homework_spring.entities;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Coupons", schema = "public")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double discount;

    @Column(name = "expire_date")
    private Date expireDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    // Constructor
    public Coupon() {}

    public Coupon(Double discount, Date expireDate, Customer customer) {
        this.discount = discount;
        this.expireDate = expireDate;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", discount=" + discount +
                ", expireDate=" + expireDate +
                ", customer=" + customer +
                '}';
    }
}
