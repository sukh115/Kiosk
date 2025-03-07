package kioskLv4;

import java.util.List;

public class Menu {
    private String category;
    private List<MenuItem> menuItems;

    public Menu(String category, List<MenuItem> menuItems){
        this.category = category;
        this. menuItems = menuItems;
    }

    public String getCategory() {
        return category;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
    public  void displayMenu() {
        System.out.println("[" + category + "]");
        for (MenuItem item : menuItems) {
            item.display();
        }
    }
}
