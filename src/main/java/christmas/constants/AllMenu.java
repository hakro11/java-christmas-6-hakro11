package christmas.constants;

public enum AllMenu {
    APPETIZER("<애피타이저>", 0),
    APPETIZER_MUSHROOM_CREAM_SOUP("양송이수프", 6_000),
    APPETIZER_TAPAS("타파스",5_500),
    APPETIZER_CAESAR_SALAD("시저샐러드",8_000),
    MAIN_DISH("<메인>", 0),
    MAIN_DISH_TBONE_STEAK("티본스테이크", 55_000),
    MAIN_DISH_BBQ_RIBS("바비큐립", 54_000),
    MAIN_DISH_SEAFOOD_SPAGHETTI("해산물파스타", 35_000),
    MAIN_DISH_CHRISTMAS_SPAGHETTI("크리스마스파스타", 25_000),
    DESSERT("<디저트>", 0),
    DESSERT_CHOCO_CAKE("초코케이크", 15_000),
    DESSERT_ICE_CREAM("아이스크림", 5_000),
    DRINK("<음료>", 0),
    DRINK_ZERO_COKE("제로콜라", 3_000),
    DRINK_RED_WINE("레드와인", 60_000),
    DRINK_CHAMPAGNE("샴페인", 25_000);


    final String MENU_NAME;
    final int MENU_PRICE;

    AllMenu(String str, int price) {
        this.MENU_NAME = str;
        this.MENU_PRICE = price;
    }

    @Override
    public String toString() {
        return MENU_NAME;
    }

    public String getMenuName() {
        return MENU_NAME;
    }

    public int getMenuPrice() {
        return MENU_PRICE;
    }
}
