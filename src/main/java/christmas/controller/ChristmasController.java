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
        this.WISH_DAY = inputView.bookingDay();
    }

    public void order() {
        inputView.bookingMenu();
        outputView.showCanGetBenefits(WISH_DAY);
        outputView.outputOrder(inputView.getInputMenu(), inputView.getInputAmountMenu());
    }
}
