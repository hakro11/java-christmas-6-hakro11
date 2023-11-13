package christmas.domain.menu;

import christmas.constants.AllMenu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dessert {
    private final List<String> dessertsName;
    private final List<Integer> dessertsPrice;
    private Map<String, Integer> bill;
    private Map<String, Integer> howManyOrder;
    private int totalPrice = 0;

    public Dessert() {
        dessertsName = List.of(
                AllMenu.DESSERT_CHOCO_CAKE.getMenuName(),
                AllMenu.DESSERT_ICE_CREAM.getMenuName()
        );

        dessertsPrice = List.of(
                AllMenu.DESSERT_CHOCO_CAKE.getMenuPrice(),
                AllMenu.DESSERT_ICE_CREAM.getMenuPrice()
        );

        bill = setBill();
        howManyOrder = setHowManyOrder();
    }

    private Map<String, Integer> setBill() {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < dessertsName.size(); i++) {
            result.put(dessertsName.get(i), dessertsPrice.get(i));
        }

        return result;
    }

    private Map<String, Integer> setHowManyOrder() {
        Map<String, Integer> result = new HashMap<>();

        for (String menuName : dessertsName) {
            result.put(menuName, 0);
        }

        return result;
    }
    public List<String> getDesserts() {
        return dessertsName;
    }

    public int calcTotalPrice() {
        int result = 0;

        for (String menuName : dessertsName) {
            result += bill.get(menuName) * howManyOrder.get(menuName);
        }

        return result;
    }
}
