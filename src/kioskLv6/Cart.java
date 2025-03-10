package kioskLv6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


// 장바구니 클래스
public class Cart {
    private final List<MenuItem> cartItems = new ArrayList<>(); // 장바구니 아이템 리스트

    // 장바구니에 메뉴 추가
    public void addItem(MenuItem item) {
        cartItems.add(item);
        System.out.println(item.getName() + "이(가) 장바구니에 추가되었습니다.");
    }

    // 장바구니에서 특정 메뉴 제거
    public void removeItem(int index) {
        if (index >= 0 && index < cartItems.size()) {
            MenuItem removedItem = cartItems.get(index);
            cartItems.remove(index);
            System.out.println(removedItem.getName() + "이(가) 장바구니에서 삭제되었습니다.");
        } else {
            System.out.println("잘못된 선택입니다. 다시 입력하세요.");
        }
    }

    // 장바구니 목록 출력
    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }

        System.out.println("=== 장바구니 목록 ===");

        AtomicInteger index = new AtomicInteger(1);

        // 중복 메뉴 합산 처리
        cartItems.stream()
                .collect(Collectors.groupingBy(item -> item, Collectors.counting())) // 개수 미리 계산
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(MenuItem::getName))) // 정렬 추가
                .forEach(entry -> {
                    MenuItem item = entry.getKey();
                    long count = entry.getValue();
                    double totalItemPrice = item.getPrice() * count;
                    System.out.printf("%d. %s | %d개 | W %.2f%n", index.getAndIncrement(), item.getName(), count, totalItemPrice);
                });


        System.out.println("총 금액: W " + calculateTotal()); // ✅ 여기에 위치해야 함!
    }



    // 총 금액 계산
    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : cartItems) {
            total += item.getPrice();
        }
        return total;
    }

    // 할인 적용 후 총 금액
    public double applyDiscount(Discount discount){
        return discount.applyDisCount(calculateTotal());
    }

    // 장바구니가 비었는지 확인
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    // 주문 완료 후 초기화
    public void checkout(Discount selectedDiscount) {
        if (cartItems.isEmpty()) {
            System.out.println("장바구니가 비어 있어 주문할 수 없습니다.");
            return;
        }

            double totalBeforeDiscount = calculateTotal();  // 할인 전 총 금액
            double totalAfterDiscount = selectedDiscount.applyDisCount(totalBeforeDiscount); // 할인 적용 후 금액

            System.out.println("주문이 완료되었습니다!");
            System.out.println(selectedDiscount.getDiscountCategory() + "할인 적용 후 총 결제 금액: W " + (totalAfterDiscount));
            cartItems.clear();  // 장바구니 초기화

    }
}
