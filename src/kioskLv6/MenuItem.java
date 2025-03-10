package kioskLv6;

// 메뉴 항목을 나타내는 클래스
public class MenuItem {
    private final Integer num; // 메뉴 번호
    private final String name; // 메뉴 이름
    private final double price; // 메뉴 가격
    private final String description; // 메뉴 설명

    public MenuItem(Integer num,String name, double price, String description) {
        this.num = num;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // 메뉴 이름 게터
    public String getName() {
        return name;
    }

    // 메뉴 가격 게터
    public double getPrice() {
        return price;
    }

    // 메뉴 설명 게터
    public String getDescription() {
        return description;
    }

    // 메뉴 정보를 출력하는 메서드
    public void display() {
        System.out.println(num +". " + name + " | W " + price + " | " + description);
    }
}
