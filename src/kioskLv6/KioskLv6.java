package kioskLv6;

import java.util.List;
import java.util.Scanner;

public class KioskLv6 {
    public static void main(String[] args) {

        List<Menu> menus = MenuData.getMenus();

        // 사용자 입력을 받기 위한 객체 생성
        Scanner scanner = new Scanner(System.in);
        Kiosk kiosk = new Kiosk(menus, scanner);
        // 키오스크 시작
        kiosk.start();

        // 프로그램 종료시 객체 닫기
        scanner.close();
    }
}

