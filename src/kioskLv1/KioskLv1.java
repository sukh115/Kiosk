package kioskLv1;

import java.util.Scanner;

public class KioskLv1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 버거 메뉴 출력
            System.out.println("[ 버거 메뉴 ]");
            System.out.println("1. ShackBurger   | W 10.6 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println("2. WhopperBurger    | W 6.8 | 차원이 다른 크기 와퍼");
            System.out.println("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println("4. BigMac     | W 5.5 | 참깨빵 위에 순쇠고기 패티2장 특별한 소스 양상추");
            System.out.println("0. 종료          | 종료");

            // 사용자로부터 입력 받기
            System.out.print("원하는 메뉴를 선택하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // nextInt() 후 남은 개행문자 처리

            // 선택한 메뉴에 따라 처리
            switch (choice) {
                case 1:
                    System.out.println("ShackBurger 선택!.");
                    break;
                case 2:
                    System.out.println("WhopperBurger 선택!");
                    break;
                case 3:
                    System.out.println("Cheeseburger 선택!");
                    break;
                case 4:
                    System.out.println("BigMac 선택!");
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return; // 프로그램 종료
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력하세요.");
            }
        }
    }
}
