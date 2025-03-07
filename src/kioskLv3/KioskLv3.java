package kioskLv3;

import kioskLv2.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KioskLv3 {
    public static void main(String[] args) {
        // 햄버거 메뉴 아이템 생성
        List<kioskLv2.MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new kioskLv2.MenuItem(1,"ShackBurger", 10.6, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new kioskLv2.MenuItem(2,"WhopperBurger", 6.8, "차원이 다른 크기 와퍼"));
        menuItems.add(new kioskLv2.MenuItem(3,"Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new kioskLv2.MenuItem(4,"BigMac", 5.5, "참깨빵 위에 순쇠고기 패티2장 특별한 소스 양상추"));

        Kiosk kiosk = new Kiosk(menuItems);
        kiosk.start();

    }
}

