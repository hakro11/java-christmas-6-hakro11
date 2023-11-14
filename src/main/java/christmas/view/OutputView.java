package christmas.view;

import christmas.constants.OutputMessage;
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
            System.out.printf("%s %d개\n",menuName.get(i), amount.get(i));
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

        return "없음";
    }
}
