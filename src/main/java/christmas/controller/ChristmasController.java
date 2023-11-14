package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.Calendar;
import christmas.domain.Discount;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private final int WISH_DAY;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Bill bill = new Bill();
    private Discount discount = new Discount(bill);
    public static final Calendar EVENT_CALENDAR = new Calendar();

    public ChristmasController() {
        this.WISH_DAY = inputView.bookingDay();
    }

    public void order() {
        inputView.bookingMenu();
        outputView.showCanGetBenefits(WISH_DAY);
        outputView.outputOrder(inputView.getInputMenu(), inputView.getInputAmountMenu());
        bill.applyMenu(inputView);
        outputView.outputPriceBeforeDiscount(bill.getTotalPriceBeforeDiscount());
    }

    public void event() {
        outputView.outputGiftEvent(bill.getTotalPriceBeforeDiscount());
    }
}
