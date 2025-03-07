package kioskLv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KioskLv2 {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    // 햄버거 메뉴 아이템 생성
    List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem(1,"ShackBurger", 10.6, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(2,"WhopperBurger", 6.8, "차원이 다른 크기 와퍼"));
        menuItems.add(new MenuItem(3,"Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(4,"BigMac", 5.5, "참깨빵 위에 순쇠고기 패티2장 특별한 소스 양상추"));

        while (true) {
        // 메뉴 출력
        System.out.println("[ 버거 메뉴 ]");
        for (MenuItem item : menuItems) {
            item.display(); // 각 메뉴 항목 출력
        }
        System.out.println("0. 종료");

        // 사용자 입력 받기
        System.out.print("원하는 메뉴를 선택하세요: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // 개행문자 처리

        // 사용자 선택 처리
        if (choice == 0) {
            System.out.println("프로그램을 종료합니다.");
            scanner.close();
            break; // 프로그램 종료
        }

        if (choice > 0 && choice <= menuItems.size()) {
            MenuItem selectedItem = menuItems.get(choice - 1); // 메뉴 항목 선택
            System.out.println(selectedItem.getName() + " 선택! " + selectedItem.getDescription());
        } else {
            System.out.println("잘못된 선택입니다. 다시 입력하세요.");
        }
    }
}
}