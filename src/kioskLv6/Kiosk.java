package kioskLv6;

import java.util.*;

// 키오스크 시스템 관리 클래스
public class Kiosk {
    // 속성
    private final List<Menu> menus;
    private final Scanner scanner;
    private final Cart cart;

    // 생성자
    public Kiosk(List<Menu> menus, Scanner scanner) {
        this.menus = menus;
        this.scanner = scanner;
        this.cart = new Cart();
    }

    // 기능

    // 키오스크 메인 실행 메서드
    public void start() {
        while (true) {
            displayMainMenu(); // 메인 메뉴 출력
            System.out.print("메뉴를 선택해주세요 : ");
            int option = getValidIntInput(); // 사용자 입력 받기
            // 홈 또는 뒤로가기 처리

            switch (option) {
                case 1 -> selectCategory();  // 카테고리 선택
                case 2 -> viewCart();        // 장바구니 보기
                case 3 -> checkout();        // 주문하기
                case 0 -> {                  // 종료
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    // 메인 메뉴 출력
    private void displayMainMenu() {
        System.out.println("\n=== 키오스크 ===");
        System.out.println("1. 메뉴 선택");
        System.out.println("2. 장바구니 보기");
        System.out.println("3. 주문하기");
        System.out.println("0. 종료");
    }

    // 카테고리 선택 화면
    private void selectCategory() {
        while (true) {
            System.out.println("\n== 메뉴 카테고리 ==");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategory());
            }
            System.out.print("메뉴 카테고리를 선택해주세요: (0. 뒤로 가기 | -1. 홈으로 가기)\"");

            int choiceCategory = getValidIntInput(); // 입력 유효성 검사
            if (returnOrHome(choiceCategory)) return;  // 홈 또는 뒤로가기 처리

            // 카테고리 옵션을 선택했을 때 해당 항목을 적용
            if (choiceCategory > 0 && choiceCategory <= menus.size()) {
                Menu selectedMenu = menus.get(choiceCategory - 1);
                selectMenuItem(selectedMenu);
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    // 메뉴 아이템 선택 화면
    private void selectMenuItem(Menu selectedMenu) {
        while (true) {
            selectedMenu.printMenuItems(); // 메뉴 출력
            System.out.println("0. 뒤로 가기 | -1. 홈으로 가기");
            System.out.print("원하는 메뉴를 선택하세요: ");

            int option = getValidIntInput(); // 입력 유효성 검사
            if (returnOrHome(option)) return;  // 홈 또는 뒤로가기 처리

            List<MenuItem> items = selectedMenu.getMenuItems();

            // 메뉴 옵션을 선택 했을때 해당 항목을 적용
            if (option > 0 && option <= items.size()) {
                MenuItem selectedItem = items.get(option - 1);
                System.out.println(selectedItem.getName() + " 선택! " + selectedItem.getDescription());
                cart.addItem(selectedItem);
            } else {
                System.out.println("잘못된 선택입니다. 다시 입력하세요.");
            }
        }
    }

    // 장바구니 보기 화면
    private void viewCart() {
        while (true) {
            cart.displayCartItems(); // 장바구니 출력;
            System.out.println("\n[1] 항목 삭제 | 0. 뒤로 가기 | -1. 홈으로 가기");
            System.out.print("선택: ");

            int option = getValidIntInput(); // 입력 유효성 검사
            if (returnOrHome(option)) return;  // 홈 또는 뒤로가기 처리

            if (option == 1) {
                System.out.print("삭제할 메뉴 이름을 입력하세요 ");
                String itemName = scanner.nextLine().trim();
                cart.removeItemByName(itemName);
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    // 주문 처리 메서드
    private void checkout() {

        while (true) {  // 올바른 입력이 나올 때까지 반복
            System.out.println("\n=== 할인 카테고리 선택 ===");

            Discount.displayDiscountOptions(); // 할인 목록 출력

            System.out.println("총 금액: W " + cart.calculateTotalPrice()); // 할인 전 총 금액 출력
            System.out.println("할인 옵션을 선택하세요 (0. 뒤로 가기 | -1. 홈으로 가기)");
            System.out.print("선택: ");

            int option = getValidIntInput();  // 입력 유효성 검사
            if (returnOrHome(option)) return;  // 홈 또는 뒤로가기 처리

            // 할인 옵션을 선택 했을 때 해당 항목을 적용
            if (option >= 1 && option <= Discount.values().length) {
                Discount selectedDiscount = Discount.values()[option - 1];
                System.out.println(selectedDiscount.getDiscountCategory() + " 할인 적용!");
                cart.checkout(selectedDiscount);
                return;  // 결제 후 checkout 종료
            } else {
                System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
                continue;  // 다시 할인 선택 화면으로 돌아감
            }
        }
    }

    // 정수 입력 검증 메서드
    private int getValidIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("유효하지 않은 입력입니다. 숫자를 입력하세요.");
            }
        }
    }

    // 상수로 관리
    // 뒤로 가기 및 홈 이동 처리
    private boolean returnOrHome(int option) {
        if (option == -1) {
            System.out.println("홈으로 이동합니다.");
            start();  // 홈으로 이동 (메인 메뉴 다시 실행)
            return true;
        }
        if (option == 0) {
            System.out.println("이전 화면으로 이동합니다.");
            return true;
        }
        return false;  // 홈으로 가지 않음
    }
}
