package christmas.domain;

import christmas.domain.menu.Appetizer;
import christmas.domain.menu.Dessert;
import christmas.domain.menu.Drink;
import christmas.domain.menu.MainDish;
import java.util.List;

public class Bill {
    private Appetizer appetizer;
    private Dessert dessert;
    private Drink drink;
    private MainDish mainDish;
    private List<String> allMenu;
    private int totalPrice;
}
