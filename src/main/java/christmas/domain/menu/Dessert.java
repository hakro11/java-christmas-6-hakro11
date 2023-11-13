package christmas.domain.menu;

import christmas.constants.AllMenu;
import java.util.List;

public class Dessert {
    final List<String> desserts;

    public Dessert() {
        desserts = List.of(
                AllMenu.DESSERT_CHOCO_CAKE.getMenuName(),
                AllMenu.DESSERT_ICE_CREAM.getMenuName()
        );
    }
}
