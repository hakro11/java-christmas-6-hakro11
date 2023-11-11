package christmas.constants;

public enum InputMessage {
    BOOKING_DAY("12월 중 식당 예상 방문 날짜는 언제인가요?"),
    BOOKING_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요."),
    BOOKING_MENU_EXAMPLE("(e.g. 해산물파스타-2,레드와인-1,초코케이크-1");

    final String INPUT_MESSAGE;

    InputMessage(String INPUT_MESSAGE) {
        this.INPUT_MESSAGE = INPUT_MESSAGE;
    }

    public String getINPUT_MESSAGE() {
        return INPUT_MESSAGE;
    }
}
