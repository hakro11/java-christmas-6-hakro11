package christmas.domain.menu;

import christmas.constants.AllMenu;
import java.util.List;

public class MainDish {
    final List<String> mainDish;

    public MainDish() {
        mainDish = List.of(
                AllMenu.MAIN_DISH_BBQ_RIBS.getMenuName(),
                AllMenu.MAIN_DISH_TBONE_STEAK.getMenuName(),
                AllMenu.MAIN_DISH_SEAFOOD_SPAGHETTI.getMenuName(),
                AllMenu.MAIN_DISH_CHRISTMAS_SPAGHETTI.getMenuName()
        );
    }
}
