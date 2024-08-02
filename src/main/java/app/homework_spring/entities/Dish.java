package app.homework_spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "Dishes")
public class Dish {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Double price;
    private Integer weight;

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getWeight() {
        return weight;
    }

    public Dish() {
    }

    public Dish(String name, Double price, Integer weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }
}
