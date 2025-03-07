package kioskLv4;

// 열거형
public enum Discount {
    SOLDIER("군인",0.15),
    STUDENT("학생",0.1),
    VIP("VIP",0.2),
    DICOUNTCOUPON("50프로 할인 쿠폰", 0.5),
    NOONE("일반",0.0);


    private final String discountCategory;
    private final double discountRate;

    Discount(String discountCategory, double discountRate){
        this.discountCategory = discountCategory;
        this.discountRate = discountRate;
    }

    public String getDiscountCategory() {
        return discountCategory;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public double applyDisCount(double amount) {
        return amount * (1 - discountRate);
    }
}
