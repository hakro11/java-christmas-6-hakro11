package christmas.constants;

public enum ErrorMessage {
    ERROR_MESSAGE("[ERROR]"),
    ERROR_NOT_AVAILABLE_DAY(" 유효하지 않은 날짜입니다."),
    ERROR_NOT_AVAILABLE_MEBU(" 유효하지 않은 주문입니다.");

    final String MESSAGE;

    ErrorMessage(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }
}
