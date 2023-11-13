package christmas.domain.menu;

import christmas.constants.AllMenu;
import java.util.List;

public class Drink {
    final List<String> drink;

    public Drink() {
        drink = List.of(
                AllMenu.DRINK_CHAMPAGNE.getMenuName(),
                AllMenu.DRINK_RED_WINE.getMenuName(),
                AllMenu.DRINK_ZERO_COKE.getMenuName()
        );
    }
}
