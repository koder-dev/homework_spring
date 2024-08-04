package app.homework_spring.DTO;

public class DishDTO {
    private String name;
    private Double price;
    private Integer weight;

    @Override
    public String toString() {
        return "DishDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }

    public DishDTO(String name, Double price, Integer weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public DishDTO() {
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

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getWeight() {
        return weight;
    }
}
