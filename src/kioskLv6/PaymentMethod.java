package kioskLv6;

public enum PaymentMethod {
    CARD("카드"),
    CASH("현금"),
    MOBILE("모바일 결제");

    private final String method;


    PaymentMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public static void displayPaymentOption() {
        int i = 1;
        for (PaymentMethod method : PaymentMethod.values()) {
            System.out.printf("%d. %s\n", i++, method.getMethod());
        }
    }
}
