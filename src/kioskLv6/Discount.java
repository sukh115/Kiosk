package kioskLv6;

// 열거형
public enum Discount {
    SOLDIER("군인", 0.15),
    STUDENT("학생", 0.1),
    VIP("VIP", 0.2),
    DICOUNTCOUPON("50프로 할인 쿠폰", 0.5),
    NOONE("일반", 0.0);

    // 속성
    private final String discountCategory; // 할인 카테고리 이름
    private final double discountRate; // 할인율

    // 생성자
    Discount(String discountCategory, double discountRate) {
        this.discountCategory = discountCategory;
        this.discountRate = discountRate;
    }

    // 할인 카테고리 게터
    public String getDiscountCategory() {
        return discountCategory;
    }

    // 할인율 카테고리 게터
    public double getDiscountRate() {
        return discountRate;
    }

    // 할인율을 적용하는 메서드
    public double applyDisCount(double amount) {
        return amount * (1 - discountRate);
    }
}
