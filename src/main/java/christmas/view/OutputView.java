package christmas.view;

import christmas.constants.Const;
import christmas.constants.DiscountMessage;
import christmas.constants.OutputMessage;
import christmas.domain.Discount;
import christmas.utils.PutCommaInNumber;
import java.util.List;

public class OutputView {
    PutCommaInNumber putCommaInNumber = new PutCommaInNumber();

    public void welcomeMessage() {
        System.out.println(OutputMessage.WELCOME_MESSAGE.getOUTPUT_MESSAGE());
    }

    public void showCanGetBenefits(int wishDay) {
        System.out.printf(OutputMessage.SHOW_CAN_GET_BENEFITS.getOUTPUT_MESSAGE(), wishDay);
    }

    public void outputOrder(List<String> menuName, List<Integer> amount) {
        System.out.println("\n\n" + OutputMessage.ORDER_MENU.getOUTPUT_MESSAGE());
        for (int i = 0; i < menuName.size(); i++) {
            System.out.printf("%s %d개\n", menuName.get(i), amount.get(i));
        }
        System.out.println("");
    }

    public void outputPriceBeforeDiscount(int price) {
        System.out.println(OutputMessage.TOTAL_PRICE_BEFORE_DISCOUNT.getOUTPUT_MESSAGE());
        System.out.println(putCommaInNumber.putCommaInNumber(price));
        System.out.println("");
    }

    public void outputGiftEvent(int price) {
        System.out.println(OutputMessage.GIFT_MENU.getOUTPUT_MESSAGE());
        System.out.println(canGetChampagne(price));
        System.out.println("");
    }

    private String canGetChampagne(int price) {
        final int REFERENCE_VALUE = 120_000;
        if (price >= REFERENCE_VALUE) {
            return OutputMessage.GIFT_MENU_CAN_GET.getOUTPUT_MESSAGE();
        }

        return Const.NONE.getStr();
    }

    public void outputBenefitMessage() {
        System.out.println(OutputMessage.SHOW_ALL_DISCOUNT.getOUTPUT_MESSAGE());
    }

    public void getAllBenefits(Discount discount) {
        int discountPrice = discount.getChristmasD_Day();
        outputChristmasDDayDiscount(discountPrice);

        outputWeekendOrWeekday(discount);

        discountPrice = discount.getSpecial();
        outputSpecialDiscount(discountPrice);

        discountPrice = discount.getGift();
        outputGiftDiscount(discountPrice);

        System.out.println("");
    }

    private void outputChristmasDDayDiscount(int discountPrice) {
        if (discountPrice > 0) {
            System.out.printf(DiscountMessage.CHRISTMAS_D_DAY_DISCOUNT.getMESSAGE(),
                    putCommaInNumber.putCommaInNumber(discountPrice));
        }
    }
    private void outputWeekendOrWeekday(Discount discount) {
        int discountPrice = discount.getWeekday();
        if (discountPrice > 0) {
            System.out.printf(DiscountMessage.WEEKDAY_DISCOUNT.getMESSAGE(),
                    putCommaInNumber.putCommaInNumber(discountPrice));
            return;
        }

        discountPrice = discount.getWeekend();
        if (discountPrice > 0) {
            System.out.printf(DiscountMessage.WEEKEND_DISCOUNT.getMESSAGE(),
                    putCommaInNumber.putCommaInNumber(discountPrice));
        }
    }

    private void outputSpecialDiscount(int discountPrice) {
        if (discountPrice > 0) {
            System.out.printf(DiscountMessage.SPECIAL_DISCOUNT.getMESSAGE(),
                    putCommaInNumber.putCommaInNumber(discountPrice));
        }
    }

    private void outputGiftDiscount(int discountPrice) {
        if (discountPrice > 0) {
            System.out.printf(DiscountMessage.GIFT_EVENT.getMESSAGE(),
                    putCommaInNumber.putCommaInNumber(discountPrice));
        }
    }

    public void outputTotalDiscountPrice(int discountPrice) {
        System.out.println(OutputMessage.TOTAL_DISCOUNT_PRICE.getOUTPUT_MESSAGE());
        System.out.println(totalDiscountPrice(discountPrice));
        System.out.println("");
    }

    private String totalDiscountPrice(int discountPrice) {
        StringBuilder sb = new StringBuilder();

        if (discountPrice != 0) {
            sb.append("-");
        }

        sb.append(putCommaInNumber.putCommaInNumber(discountPrice));

        return sb.toString();
    }

    public void expectedPrice(int priceBeforeDiscount, int discountPrice) {
        System.out.println(OutputMessage.EXPECTED_PRICE.getOUTPUT_MESSAGE());
        System.out.println(putCommaInNumber.putCommaInNumber(priceBeforeDiscount-discountPrice));
        System.out.println("");
    }

    public void outputBadge(String badgeName) {
        System.out.println(OutputMessage.SHOW_BADGE.getOUTPUT_MESSAGE());
        System.out.println(badgeName);
    }
}
