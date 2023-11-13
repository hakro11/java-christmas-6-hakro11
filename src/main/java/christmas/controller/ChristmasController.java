package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.Calendar;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private final int WISH_DAY;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Bill bill = new Bill();
    public static final Calendar EVENT_CALENDAR = new Calendar();

    public ChristmasController() {
        int input = inputView.bookingDay();
        this.WISH_DAY = input;
    }

    public void order() {
        inputView.bookingMenu();
        outputView.outputOrder(inputView.getInputMenu(), inputView.getInputAmountMenu(), WISH_DAY);
    }
}
