package app.homework_spring.DTO;

import java.util.List;

public class OrderDTO {
    private List<String> dishesName;
    private String customerName;
    private Long couponId;

    @Override
    public String toString() {
        return "OrderDTO{" +
                "dishesName=" + dishesName +
                ", customerName='" + customerName + '\'' +
                ", couponId=" + couponId +
                '}';
    }

    public void setDishesName(List<String> dishesName) {
        this.dishesName = dishesName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public List<String> getDishesName() {
        return dishesName;
    }


    public String getCustomerName() {
        return customerName;
    }

    public Long getCouponId() {
        return couponId;
    }

    public OrderDTO(List<String> dishesName, String customerName, Long couponId) {
        this.dishesName = dishesName;
        this.customerName = customerName;
        this.couponId = couponId;
    }

    public OrderDTO() {
    }
}
