package christmas.view;

import christmas.constants.OutputMessage;
import java.util.List;

public class OutputView {
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
    }
}
