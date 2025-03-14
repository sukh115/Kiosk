package kioskLv6;

import java.util.*;


// 장바구니 클래스
public class Cart {
    private final Map<MenuItem, Integer> cartItems = new LinkedHashMap<>(); // 장바구니 아이템 리스트 LinkeHashMap으로 입력 순서 유지

    // 장바구니에 메뉴 추가
    public void addItem(MenuItem item) {
        cartItems.put(item, cartItems.getOrDefault(item, 0) + 1);
        System.out.println(item.getName() + "이(가) 장바구니에 추가되었습니다.");
    }

    // 장바구니에서 특정 메뉴 제거
    public void removeItem(MenuItem item) {
        if (cartItems.containsKey(item)) {
            int count = cartItems.get(item);
            if (count > 1) {
                cartItems.put(item, count - 1);
            } else {
                cartItems.remove(item);
            }
            System.out.println(item.getName() + "이(가) 장바구니에서 삭제되었습니다.");
        } else {
            System.out.println("잘못된 선택입니다. 다시 입력하세요.");
        }
    }

    // 장바구니 목록 출력
    public void displayCartItems() {
        if (cartItems.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }

        System.out.println("\n=== 장바구니 목록 ===");

        // 중복된 메뉴 개수를 계산하고 정렬하여 출력
        cartItems.forEach((item, count) -> { // 최종 출력
            double totalItemPrice = item.getPrice() * count;
            System.out.printf("%s | %d개 | W %.2f%n", item.getName(), count, totalItemPrice);
        });

        System.out.println("총 금액: W " + calculateTotalPrice());
    }

    // 삭제할 키값 찾기
    public void removeItemByName(String itemName) {
        Optional<MenuItem> removeToItem = cartItems.keySet().stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst();

        if (removeToItem.isPresent()) {
            removeItem(removeToItem.get());
        } else {
            System.out.println("해당 메뉴가 장바구니에 없습니다.");
        }
    }


    // 총 금액 계산
    public Double calculateTotalPrice() {
        // 스트림으로 총 금액 계산
        return cartItems.entrySet().stream()
                .mapToDouble(total -> total.getKey().getPrice() * total.getValue())
                .sum();
    }




    // 주문 목록 생성
    public Order createOrder(Discount discount, PaymentMethod paymentMethod) {
        double totalBeforeDiscount = calculateTotalPrice();
        double totalAfterDiscount = discount.applyDiscount(totalBeforeDiscount);

        Order newOrder = new Order(cartItems, discount, paymentMethod, totalAfterDiscount);
        cartItems.clear(); // 주문 후 자동 초기화
        return newOrder;
    }
}
