package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constants.ErrorMessage;
import christmas.constants.InputMessage;

public class InputView {
    private final int DAY_START = 1;
    private final int DAY_LAST = 31;

    public int bookingDay() {
        System.out.println(InputMessage.BOOKING_DAY.getINPUT_MESSAGE());
        try {
            int day = convertStrToInt(Console.readLine());
            if (checkRange(day)) {
                return day;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return bookingDay();
        }

        return bookingDay();
    }

    private int convertStrToInt(String input) {
        int convert;
        try {
            convert = Integer.parseInt(input);
            return convert;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(makeErrorMessage());
        }
    }

    private boolean checkRange(int day) {
        if (day >= DAY_START && day <= DAY_LAST) {
            return true;
        }

        throw new IllegalArgumentException(makeErrorMessage());
    }

    private String makeErrorMessage() {
        StringBuilder sb = new StringBuilder();

        sb.append(ErrorMessage.ERROR_MESSAGE.getMESSAGE());
        sb.append(ErrorMessage.ERROR_NOT_AVAILABLE_DAY.getMESSAGE());

        return sb.toString();
    }
}
