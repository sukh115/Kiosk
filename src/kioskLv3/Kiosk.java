package kioskLv3;

import kioskLv2.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    // 햄버거 메뉴 아이템 생성
    List<MenuItem> menuItems = new ArrayList<>();

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);


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
                break; // 프로그램 종료
            }

            if (choice > 0 && choice <= menuItems.size()) {
                MenuItem selectedItem = menuItems.get(choice - 1); // 메뉴 항목 선택
                System.out.println(selectedItem.getName() + " 선택! " + selectedItem.getDescription());
            } else {
                System.out.println("잘못된 선택입니다. 다시 입력하세요.");
            }
        }
        scanner.close();
    }
}
