package kioskLv6;

import java.util.ArrayList;
import java.util.List;

public class MenuData {
    static List<Menu> getMenus() {
        // 키오스크 메뉴 목록 생성
        List<Menu> menus = new ArrayList<>();

        // 햄버거 메뉴 항목 추가
        List<MenuItem> burgerItems = new ArrayList<>();
        burgerItems.add(new MenuItem("ShackBurger", 10600, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("WhopperBurger", 6800, "차원이 다른 크기 와퍼"));
        burgerItems.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("BigMac", 5500, "참깨빵 위에 순쇠고기 패티2장 특별한 소스 양상추"));

        // 음료수 메뉴 항목 추가
        List<MenuItem> drinkItems = new ArrayList<>();
        drinkItems.add(new MenuItem("콜라", 2500, "코카콜라"));
        drinkItems.add(new MenuItem("사이다", 2500, "칠성사이다"));
        drinkItems.add(new MenuItem("아이스 아메리카노", 2000, "커피"));
        drinkItems.add(new MenuItem("밀크쉐이크", 4500, "상하목장우유 밀크쉐이크"));
        drinkItems.add(new MenuItem("물", 1000, "에비앙"));

        // 사이드 메뉴 항목 추가
        List<MenuItem> sideItems = new ArrayList<>();
        sideItems.add(new MenuItem("감자 튀김", 2500, "소금으로 간을한 감자튀김"));
        sideItems.add(new MenuItem("양념 감자튀김", 3000, "매콤한 시즈닝 감자튀김"));
        sideItems.add(new MenuItem("콘 아이스크림", 1000, "상하 목장 우유 아이스크림"));
        sideItems.add(new MenuItem("코울슬로", 2000, "콘 양배추 당근 마요네즈로 건강과 맛을 동시에"));


        // 가게 카테고리 추가
        menus.add(new Menu("버거", burgerItems));
        menus.add(new Menu("음료", drinkItems));
        menus.add(new Menu("사이드", sideItems));

        return menus;
    }
}
