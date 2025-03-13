package kioskLv6;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    // 속성
    private static final OrderHistory INSTANCE = new OrderHistory();
    private final List<Order> orders = new ArrayList<>();

    // 생성자
    // 기능
    private OrderHistory() {} // 외부에서 객체 생성을 막음

    public static OrderHistory getInstance() {
        return INSTANCE;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }


    // 주문 내역 리스트
    public void displayOrdersList() {
        if (orders.isEmpty()) { // 주문이 비어있을 때
            System.out.println("주문 내역이 없습니다.");
            return;
        }
        orders.forEach(Order::printReceipt);
    }
}
