package app.homework_spring.DTO;

public class CouponDTO {
    private String customerName;
    private Double couponDiscount;

    @Override
    public String toString() {
        return "CouponDTO{" +
                "customerName='" + customerName + '\'' +
                ", couponDiscount=" + couponDiscount +
                '}';
    }

    public CouponDTO() {
    }

    public CouponDTO(String customerName, Double couponDiscount) {
        this.customerName = customerName;
        this.couponDiscount = couponDiscount;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCouponDiscount(Double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Double getCouponDiscount() {
        return couponDiscount;
    }
}
