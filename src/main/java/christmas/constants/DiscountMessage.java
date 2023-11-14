package christmas.constants;

public enum DiscountMessage {
    CHRISTMAS_D_DAY_DISCOUNT("크리스마스 디데이 할인: -%s\n"),
    WEEKDAY_DISCOUNT("평일 할인: -%s\n"),
    WEEKEND_DISCOUNT("주말 할인: -%s\n"),
    SPECIAL_DISCOUNT("특별 할인 : -%s\n"),
    GIFT_EVENT("증정 이벤트: -%s\n");

    private final String MESSAGE;
    DiscountMessage(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }
}
