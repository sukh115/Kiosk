package kioskLv2;

public class MenuItem {
    private Integer num;
    private String name;
    private double price;
    private String description;

    public MenuItem(Integer num, String name, double price, String description) {
        this.num = num;
        this.name = name;
        this.price = price;
        this.description = description;
    }


    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }


    public void display() {
        System.out.println(num + ". " + name + " | W " + price + " | " + description);
    }
}
