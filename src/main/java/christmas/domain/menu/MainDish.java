package christmas.domain.menu;

import christmas.constants.AllMenu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainDish {
    private final List<String> MAINDISH_NAME;
    private final List<Integer> MAINDISH_PRICE;
    private Map<String, Integer> bill;
    private Map<String, Integer> howManyOrder;
    private int totalPrice = 0;
    public MainDish() {
        MAINDISH_NAME = List.of(
                AllMenu.MAIN_DISH_BBQ_RIBS.getMenuName(),
                AllMenu.MAIN_DISH_TBONE_STEAK.getMenuName(),
                AllMenu.MAIN_DISH_SEAFOOD_SPAGHETTI.getMenuName(),
                AllMenu.MAIN_DISH_CHRISTMAS_SPAGHETTI.getMenuName()
        );

        MAINDISH_PRICE = List.of(
                AllMenu.MAIN_DISH_BBQ_RIBS.getMenuPrice(),
                AllMenu.MAIN_DISH_TBONE_STEAK.getMenuPrice(),
                AllMenu.MAIN_DISH_SEAFOOD_SPAGHETTI.getMenuPrice(),
                AllMenu.MAIN_DISH_CHRISTMAS_SPAGHETTI.getMenuPrice()
        );

        bill = setBill();
        howManyOrder = setHowManyOrder();
    }

    private Map<String, Integer> setBill() {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < MAINDISH_NAME.size(); i++) {
            result.put(MAINDISH_NAME.get(i), MAINDISH_PRICE.get(i));
        }

        return result;
    }
    private Map<String, Integer> setHowManyOrder() {
        Map<String, Integer> result = new HashMap<>();

        for (String menuName : MAINDISH_NAME) {
            result.put(menuName, 0);
        }

        return result;
    }

    public List<String> getMainDish() {
        return MAINDISH_NAME;
    }

    public int calcTotalPrice() {
        int result = 0;

        for (String menuName : MAINDISH_NAME) {
            result += bill.get(menuName) * howManyOrder.get(menuName);
        }

        return result;
    }
}
