package kioskLv6;

import java.util.List;
import java.util.stream.IntStream;

// 열거형
public enum Discount {
    SOLDIER("군인", 0.15),
    STUDENT("학생", 0.1),
    VIP("VIP", 0.2),
    DISCOUNTCOUPON("50프로 할인 쿠폰", 0.5),
    NOONE("일반", 0.0);

    // 속성
    private final String discountCategory; // 할인 카테고리 이름
    private final Double discountRate; // 할인율

    // 생성자
    Discount(String discountCategory, Double discountRate) {
        this.discountCategory = discountCategory;
        this.discountRate = discountRate;
    }

    // 할인 카테고리 게터
    public String getDiscountCategory() {
        return discountCategory;
    }

    // 할인율 카테고리 게터
    public Double getDiscountRate() {
        return discountRate;
    }

    // 할인율을 적용하는 메서드
    public Double applyDiscount(Double amount) {
        return amount * (1 - discountRate);
    }

    // 할인 목록을 출력하는 메서드
    public static void printDiscountList(){
        // 할인 카테고리 목록
        IntStream.range(0, Discount.values().length)
                .forEach(i -> System.out.println(
                        String.format("%d. %s || %.0f%%",
                                i + 1,
                                Discount.values()[i].getDiscountCategory(),
                                Discount.values()[i].getDiscountRate() * 100)
                ));
    }
}
