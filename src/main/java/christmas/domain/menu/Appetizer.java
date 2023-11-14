package christmas.domain.menu;

import christmas.constants.AllMenu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Appetizer {
    private final List<String> APPETIZERS_NAME;
    private final List<Integer> APPETIZERS_PRICE;
    private Map<String, Integer> bill;
    private Map<String, Integer> howManyOrder;
    private int totalPrice = 0;

    public Appetizer() {
        APPETIZERS_NAME = List.of(
                AllMenu.APPETIZER_MUSHROOM_CREAM_SOUP.getMenuName(),
                AllMenu.APPETIZER_TAPAS.getMenuName(),
                AllMenu.APPETIZER_CAESAR_SALAD.getMenuName()
        );

        APPETIZERS_PRICE = List.of(
                AllMenu.APPETIZER_MUSHROOM_CREAM_SOUP.getMenuPrice(),
                AllMenu.APPETIZER_TAPAS.getMenuPrice(),
                AllMenu.APPETIZER_CAESAR_SALAD.getMenuPrice()
        );

        bill = setBill();
        howManyOrder = setHowManyOrder();

    }

    private Map<String, Integer> setBill() {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < APPETIZERS_NAME.size(); i++) {
            result.put(APPETIZERS_NAME.get(i), APPETIZERS_PRICE.get(i));
        }

        return result;
    }
    private Map<String, Integer> setHowManyOrder() {
        Map<String, Integer> result = new HashMap<>();

        for (String menuName : APPETIZERS_NAME) {
            result.put(menuName, 0);
        }

        return result;
    }

    public List<String> getAppetizers() {
        return APPETIZERS_NAME;
    }

    public Map<String, Integer> getBill() {
        return bill;
    }

    public Map<String, Integer> getHowManyOrder() {
        return howManyOrder;
    }

    public void calcTotalPrice() {
        int result = 0;

        for (String menuName : APPETIZERS_NAME) {
            result += bill.get(menuName) * howManyOrder.get(menuName);
        }

        totalPrice = result;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
