package christmas.domain.menu;

import christmas.constants.AllMenu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Appetizer {
    private final List<String> appetizersName;
    private final List<Integer> appetizersPrice;
    private Map<String, Integer> bill;
    private Map<String, Integer> howManyOrder;
    private int totalPrice = 0;

    public Appetizer() {
        appetizersName = List.of(
                AllMenu.APPETIZER_MUSHROOM_CREAM_SOUP.getMenuName(),
                AllMenu.APPETIZER_TAPAS.getMenuName(),
                AllMenu.APPETIZER_CAESAR_SALAD.getMenuName()
        );

        appetizersPrice = List.of(
                AllMenu.APPETIZER_MUSHROOM_CREAM_SOUP.getMenuPrice(),
                AllMenu.APPETIZER_TAPAS.getMenuPrice(),
                AllMenu.APPETIZER_CAESAR_SALAD.getMenuPrice()
        );

        bill = setBill();
        howManyOrder = setHowManyOrder();

    }

    private Map<String, Integer> setBill() {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < appetizersName.size(); i++) {
            result.put(appetizersName.get(i), appetizersPrice.get(i));
        }

        return result;
    }
    private Map<String, Integer> setHowManyOrder() {
        Map<String, Integer> result = new HashMap<>();

        for (String menuName : appetizersName) {
            result.put(menuName, 0);
        }

        return result;
    }

    public List<String> getAppetizers() {
        return appetizersName;
    }

    public int calcTotalPrice() {
        int result = 0;

        for (String menuName : appetizersName) {
            result += bill.get(menuName) * howManyOrder.get(menuName);
        }

        return result;
    }
}
