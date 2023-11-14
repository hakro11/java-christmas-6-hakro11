package christmas.constants;

public enum OutputMessage {
    WELCOME_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    SHOW_CAN_GET_BENEFITS("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리보기!"),
    ORDER_MENU("<주문 메뉴>"),
    TOTAL_PRICE_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    GIFT_MENU("<증정 메뉴>"),
    GIFT_MENU_CAN_GET("샴페인 1개"),
    SHOW_ALL_DISCOUNT("<혜택 내역>"),
    TOTAL_DISCOUNT_PRICE("<총혜택 금액>"),
    EXPECTED_PRICE("<할인 후 예상 결제 금액>"),
    SHOW_BADGE("<12월 이벤트 배지>");

    final String OUTPUT_MESSAGE;

    OutputMessage(String OUTPUT_MESSAGE) {
        this.OUTPUT_MESSAGE = OUTPUT_MESSAGE;
    }

    public String getOUTPUT_MESSAGE() {
        return OUTPUT_MESSAGE;
    }
}
