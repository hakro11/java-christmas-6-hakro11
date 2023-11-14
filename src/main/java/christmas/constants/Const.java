package christmas.constants;

public enum Const {
    WEEKEND("Weekend"),
    WEEKDAY("Weekday"),
    SPECIAL("Special");

    final String str;

    Const(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
