package christmas.domain.menu;

import christmas.constants.AllMenu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dessert {
    private final List<String> DESSERTS_NAME;
    private final List<Integer> DESSERTS_PRICE;
    private Map<String, Integer> bill;
    private Map<String, Integer> howManyOrder;
    private int totalPrice = 0;

    public Dessert() {
        DESSERTS_NAME = List.of(
                AllMenu.DESSERT_CHOCO_CAKE.getMenuName(),
                AllMenu.DESSERT_ICE_CREAM.getMenuName()
        );

        DESSERTS_PRICE = List.of(
                AllMenu.DESSERT_CHOCO_CAKE.getMenuPrice(),
                AllMenu.DESSERT_ICE_CREAM.getMenuPrice()
        );

        bill = setBill();
        howManyOrder = setHowManyOrder();
    }

    private Map<String, Integer> setBill() {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < DESSERTS_NAME.size(); i++) {
            result.put(DESSERTS_NAME.get(i), DESSERTS_PRICE.get(i));
        }

        return result;
    }

    private Map<String, Integer> setHowManyOrder() {
        Map<String, Integer> result = new HashMap<>();

        for (String menuName : DESSERTS_NAME) {
            result.put(menuName, 0);
        }

        return result;
    }
    public List<String> getDesserts() {
        return DESSERTS_NAME;
    }

    public int calcTotalPrice() {
        int result = 0;

        for (String menuName : DESSERTS_NAME) {
            result += bill.get(menuName) * howManyOrder.get(menuName);
        }

        return result;
    }
}
