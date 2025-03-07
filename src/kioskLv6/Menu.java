package kioskLv6;

import java.util.List;

// 메뉴 카테고리를 관리하는 클래스
public class Menu {
    private final String category; // 메뉴 카테고리 이름
    private final List<MenuItem> menuItems; // 해당 카테고리의 메뉴 목록

    public Menu(String category, List<MenuItem> menuItems){
        this.category = category;
        this. menuItems = menuItems;
    }

    // 메뉴 카테고리 이름 게터
    public String getCategory() {
        return category;
    }

    // 해당 카테고리의 메뉴 목록 게터
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    // 해당 카테고리 메뉴를 출력하는 메서드
    public  void displayMenu() {
        System.out.println("[" + category + "]");
        for (MenuItem item : menuItems) {
            item.display();
        }
    }
}
