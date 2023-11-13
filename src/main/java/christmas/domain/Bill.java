package christmas.domain;

import christmas.domain.menu.Appetizer;
import christmas.domain.menu.Dessert;
import christmas.domain.menu.Drink;
import christmas.domain.menu.MainDish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bill {
    private Appetizer appetizer = new Appetizer();
    private Dessert dessert = new Dessert();
    private Drink drink = new Drink();
    private MainDish mainDish = new MainDish();
    private List<String> allMenu = setAllMenu();
    private Map<String, Integer> menuMap = new HashMap<>();
    private int totalPrice = 0;

    private List<String> setAllMenu () {
        List<String> result = new ArrayList<>();

        addMenu(result, appetizer.getAppetizers());
        addMenu(result, dessert.getDesserts());
        addMenu(result, drink.getDrink());
        addMenu(result, mainDish.getMainDish());

        return result;
    }

    private void addMenu(List<String> result, List<String> menu) {
        for (String menuName : menu) {
            result.add(menuName);
        }
    }

    public void calcPrice() {
        totalPrice += appetizer.calcTotalPrice();
        totalPrice += dessert.calcTotalPrice();
        totalPrice += mainDish.calcTotalPrice();
        totalPrice += drink.calcTotalPrice();
    }
}
