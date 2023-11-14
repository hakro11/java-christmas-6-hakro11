package christmas.domain;

import christmas.domain.menu.Appetizer;
import christmas.domain.menu.Dessert;
import christmas.domain.menu.Drink;
import christmas.domain.menu.MainDish;
import christmas.view.InputView;
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
    private int totalPriceBeforeDiscount = 0;
    private int totalPriceAfterDiscount = 0;

    private List<String> setAllMenu() {
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

    public boolean contains(String input) {
        if (allMenu.contains(input)) {
            return true;
        }

        return false;
    }

    public Drink getDrink() {
        return drink;
    }

    public void applyMenu(InputView inputView) {
        List<String> menu = inputView.getInputMenu();
        List<Integer> amount = inputView.getInputAmountMenu();

        for (int i = 0; i < menu.size(); i++) {
            String menuName = menu.get(i);
            int menuAmount = amount.get(i);
            whatKindOfMenu(menuName, menuAmount);
        }

        applyPrice();
        calcPrice();
    }

    private void whatKindOfMenu(String menuName, int menuAmount) {
        if (appetizer.getAppetizers().contains(menuName)) {
            appetizer.order(menuName, menuAmount);
            return;
        }

        if (dessert.getDesserts().contains(menuName)) {
            dessert.order(menuName, menuAmount);
            return;
        }

        if (mainDish.getMainDish().contains(menuName)) {
            mainDish.order(menuName, menuAmount);
            return;
        }

        if (drink.getDrink().contains(menuName)) {
            drink.order(menuName, menuAmount);
        }
    }

    private void applyPrice() {
        appetizer.calcTotalPrice();
        dessert.calcTotalPrice();
        mainDish.calcTotalPrice();
        drink.calcTotalPrice();
    }

    private void calcPrice() {
        totalPriceBeforeDiscount += appetizer.getTotalPrice();
        totalPriceBeforeDiscount += dessert.getTotalPrice();
        totalPriceBeforeDiscount += mainDish.getTotalPrice();
        totalPriceBeforeDiscount += drink.getTotalPrice();
    }

    public void applyDiscount() {

    }

    public int getTotalPriceBeforeDiscount() {
        return totalPriceBeforeDiscount;
    }

    public int getTotalPriceAfterDiscount() {
        return totalPriceAfterDiscount;
    }
}
