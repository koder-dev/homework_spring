package app.homework_spring.DTO;

import app.homework_spring.entities.Customer;

public class CustomerDTO {
    private String fullName;

    public CustomerDTO() {
    }

    public CustomerDTO(Customer customer) {
        this.fullName = customer.getFullName();
    }

    public CustomerDTO(String fullName) {
        this.fullName = fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
