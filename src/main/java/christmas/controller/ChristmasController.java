package christmas.controller;

import christmas.constants.Const;
import christmas.domain.Badge;
import christmas.domain.Bill;
import christmas.domain.Calendar;
import christmas.domain.Discount;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private final int WISH_DAY;
    private final int CAN_GET_SPECIAL = 120_000;
    private int totalDiscount = 0;
    private final Calendar EVENT_CALENDAR = new Calendar();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Bill bill = new Bill();
    private Discount discount = new Discount();

    public ChristmasController() {
        outputView.welcomeMessage();
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
        outputView.outputBenefitMessage();
        if (totalDiscount == 0) {
            System.out.println(Const.NONE.getStr());
            System.out.println("");
            return;
        }
        outputView.getAllBenefits(discount);
    }

    public void benefitPrice() {
        outputView.outputTotalDiscountPrice(totalDiscount);
        outputView.expectedPrice(bill.getTotalPriceBeforeDiscount(), totalDiscount);
    }

    public void eventBadge() {
        Badge badge = new Badge(totalDiscount);
        String badgeName = badge.getBADGE();
        outputView.outputBadge(badgeName);
    }

    public void applyDiscount() {
        discount.d_dayDiscount(WISH_DAY);
        totalDiscount += discount.getChristmasD_Day();
        String event = EVENT_CALENDAR.whatDay(WISH_DAY);
        findCanGetDiscount(event);
    }

    private void findCanGetDiscount(String event) {
        applyWeekendOrWeekday(event);
        if (event.contains(Const.SPECIAL.getStr())) {
            discount.specialDiscount();
            totalDiscount += discount.getSpecial();
        }

        if (bill.getTotalPriceBeforeDiscount() >= CAN_GET_SPECIAL) {
            discount.giftEvent();
            totalDiscount += discount.getGift();
        }
    }

    private void applyWeekendOrWeekday(String event) {
        int amount = 0;

        if (event.contains(Const.WEEKEND.getStr())) {
            amount = bill.getMainDish().howManyOrder();
            discount.weekendDiscount(amount);
            totalDiscount += discount.getWeekend();
            return;
        }

        if (event.contains(Const.WEEKDAY.getStr())) {
            amount = bill.getDessert().howManyOrder();
            discount.weekdayDiscount(amount);
            totalDiscount += discount.getWeekday();
        }
    }
}
