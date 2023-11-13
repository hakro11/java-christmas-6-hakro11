package christmas.domain.menu;

import christmas.constants.AllMenu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drink {
    private final List<String> DRINK_NAME;
    private final List<Integer> DRINK_PRICE;
    private Map<String, Integer> bill;
    private Map<String, Integer> howManyOrder;
    private int totalPrice = 0;
    public Drink() {
        DRINK_NAME = List.of(
                AllMenu.DRINK_CHAMPAGNE.getMenuName(),
                AllMenu.DRINK_RED_WINE.getMenuName(),
                AllMenu.DRINK_ZERO_COKE.getMenuName()
        );

        DRINK_PRICE = List.of(
                AllMenu.DRINK_CHAMPAGNE.getMenuPrice(),
                AllMenu.DRINK_RED_WINE.getMenuPrice(),
                AllMenu.DRINK_ZERO_COKE.getMenuPrice()
        );

        bill = setBill();
        howManyOrder = setHowManyOrder();
    }

    private Map<String, Integer> setBill() {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < DRINK_NAME.size(); i++) {
            result.put(DRINK_NAME.get(i), DRINK_PRICE.get(i));
        }

        return result;
    }

    private Map<String, Integer> setHowManyOrder() {
        Map<String, Integer> result = new HashMap<>();

        for (String menuName : DRINK_NAME) {
            result.put(menuName, 0);
        }

        return result;
    }

    public List<String> getDrink() {
        return DRINK_NAME;
    }

    public Map<String, Integer> getBill() {
        return bill;
    }

    public Map<String, Integer> getHowManyOrder() {
        return howManyOrder;
    }

    public int calcTotalPrice() {
        int result = 0;

        for (String menuName : DRINK_NAME) {
            result += bill.get(menuName) * howManyOrder.get(menuName);
        }

        return result;
    }
}
