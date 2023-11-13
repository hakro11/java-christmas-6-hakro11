package christmas.domain.menu;

import christmas.constants.AllMenu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drink {
    private final List<String> drinkName;
    private final List<Integer> drinkPrice;
    private Map<String, Integer> bill;
    private Map<String, Integer> howManyOrder;
    private int totalPrice = 0;
    public Drink() {
        drinkName = List.of(
                AllMenu.DRINK_CHAMPAGNE.getMenuName(),
                AllMenu.DRINK_RED_WINE.getMenuName(),
                AllMenu.DRINK_ZERO_COKE.getMenuName()
        );

        drinkPrice = List.of(
                AllMenu.DRINK_CHAMPAGNE.getMenuPrice(),
                AllMenu.DRINK_RED_WINE.getMenuPrice(),
                AllMenu.DRINK_ZERO_COKE.getMenuPrice()
        );

        bill = setBill();
        howManyOrder = setHowManyOrder();
    }

    private Map<String, Integer> setBill() {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < drinkName.size(); i++) {
            result.put(drinkName.get(i), drinkPrice.get(i));
        }

        return result;
    }

    private Map<String, Integer> setHowManyOrder() {
        Map<String, Integer> result = new HashMap<>();

        for (String menuName : drinkName) {
            result.put(menuName, 0);
        }

        return result;
    }

    public List<String> getDrink() {
        return drinkName;
    }

    public int calcTotalPrice() {
        int result = 0;

        for (String menuName : drinkName) {
            result += bill.get(menuName) * howManyOrder.get(menuName);
        }

        return result;
    }
}
