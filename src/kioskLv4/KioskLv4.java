package kioskLv4;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KioskLv4 {
    public static void main(String[] args) {
        // 햄버거 메뉴 아이템 생성
        List<Menu> menus = new ArrayList<>();

        // 햄버거 메뉴
        List<MenuItem> bugerItems = new ArrayList<>();
        bugerItems.add(new MenuItem(1,"ShackBurger", 10.6, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        bugerItems.add(new MenuItem(2,"WhopperBurger", 6.8, "차원이 다른 크기 와퍼"));
        bugerItems.add(new MenuItem(3,"Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        bugerItems.add(new MenuItem(4,"BigMac", 5.5, "참깨빵 위에 순쇠고기 패티2장 특별한 소스 양상추"));

        // 음료수 메뉴
        List<MenuItem> drinkItems = new ArrayList<>();
        drinkItems.add(new MenuItem(1,"콜라",2.5,"코카콜라"));
        drinkItems.add(new MenuItem(2,"사이다",2.5,"칠성사이다"));
        drinkItems.add(new MenuItem(3,"아이스 아메리카노",2.0,"커피"));
        drinkItems.add(new MenuItem(4,"밀크쉐이크",4.5,"상하목장우유 밀크쉐이크"));
        drinkItems.add(new MenuItem(5,"물",1.0,"에비앙"));

        // 사이드 메뉴
        List<MenuItem> sideItems = new ArrayList<>();
        sideItems.add(new MenuItem(1,"감자 튀김",2.5,"소금으로 간을한 감자튀김"));
        sideItems.add(new MenuItem(2,"양념 감자튀김",3.0,"매콤한 시즈닝 감자튀김"));
        sideItems.add(new MenuItem(3,"콘 아이스크림",1.0,"상하 목장 우유 아이스크림"));
        sideItems.add(new MenuItem(4,"코울슬로",2.0,"콘 양배추 당근 마요네즈로 건강과 맛을 동시에"));


        // 가게 카테고리
        menus.add(new Menu("버거", bugerItems));
        menus.add(new Menu("음료", drinkItems));
        menus.add(new Menu("사이드", sideItems));


        Scanner scanner = new Scanner(System.in);
        Kiosk kiosk = new Kiosk(menus, scanner);
        // 키오스크 시작
        kiosk.start();

        // 종료
        scanner.close();
    }
}

