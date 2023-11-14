package christmas.domain;

import christmas.constants.AllMenu;

public class Discount {
    final private int RATIO = 100;
    final private int DISCOUNT = 2023;
    private int christmasD_Day = 1_000;
    private int weekday = 0;
    private int weekend = 0;

    private int special = 0;
    private int gift = 0;

    public int getChristmasD_Day() {
        return christmasD_Day;
    }

    public int getWeekday() {
        return weekday;
    }

    public int getWeekend() {
        return weekend;
    }

    public int getSpecial() {
        return special;
    }

    public int getGift() {
        return gift;
    }

    public int d_dayDiscount(int wishDay) {
        final int EVENT_START = 1;
        final int EVENT_END = 25;

        if (wishDay >= EVENT_START && wishDay <= EVENT_END) {
            christmasD_Day += (wishDay-1)*RATIO;
            return christmasD_Day;
        }

        christmasD_Day = 0;
        return christmasD_Day;
    }

    public int weekdayDiscount(int menuAmount) {
        weekday = DISCOUNT * menuAmount;
        return weekday;
    }

    public int weekendDiscount(int menuAmount) {
        weekend = DISCOUNT * menuAmount;
        return weekend;
    }

    public int specialDiscount() {
        special = 1000;
        return special;
    }

    public int giftEvent() {
        gift = AllMenu.DRINK_CHAMPAGNE.getMenuPrice();
        return gift;
    }
}
