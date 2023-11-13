package christmas.domain.menu;

import christmas.constants.AllMenu;
import java.util.List;

public class Appetizer {
    final List<String> appetizers;

    public Appetizer() {
        appetizers = List.of(
                AllMenu.APPETIZER_MUSHROOM_CREAM_SOUP.getMenuName(),
                AllMenu.APPETIZER_TAPAS.getMenuName(),
                AllMenu.APPETIZER_CAESAR_SALAD.getMenuName()
        );
    }
}
