package kioskLv6;

import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
    // 속성
    private static Integer ORDER_SEQUENCE = 1;
    private final Integer orderNumber;
    private final Map<MenuItem, Integer> items;
    private final Discount discount;
    private final PaymentMethod paymentMethod;
    private final Double totalPrice;

    // 생성자
    public Order(Map<MenuItem, Integer> items, Discount discount, PaymentMethod paymentMethod, Double totalPrice) {
        this.orderNumber = ORDER_SEQUENCE++;
        this.items = new LinkedHashMap<>(items);
        this.discount = discount;
        this.paymentMethod = paymentMethod;
        this.totalPrice = totalPrice;
    }

    // 기능
    // 영수증 출력
    public void printReceipt() {
        System.out.println("\n===== 영수증 =====");
        System.out.println("주문 번호: " + orderNumber);
        items.forEach((item, count) ->
                System.out.printf("%s | %d개 | W %d\n",
                        item.getName(), count, item.getPrice() * count));
        System.out.println("------------------");
        System.out.println("할인: " + discount.getDiscountCategory());
        System.out.println("결제 방법: " + paymentMethod.getMethod());
        System.out.println("총 결제 금액: W " + totalPrice);
        System.out.println("=================\n");
    }
}
