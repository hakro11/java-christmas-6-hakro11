package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constants.ErrorMessage;
import christmas.constants.InputMessage;
import christmas.domain.Bill;
import christmas.domain.menu.Drink;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final int DAY_START = 1;
    private final int DAY_LAST = 31;
    private List<String> inputMenu = new ArrayList<>();
    private List<Integer> inputAmountMenu = new ArrayList<>();

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

    public int convertStrToInt(String input) {
        int convert;
        try {
            convert = Integer.parseInt(input);
            return convert;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(makeErrorMessageNotCorrectDay());
        }
    }

    public boolean checkRange(int day) {
        if (day >= DAY_START && day <= DAY_LAST) {
            return true;
        }

        throw new IllegalArgumentException(makeErrorMessageNotCorrectDay());
    }

    private String makeErrorMessageNotCorrectDay() {
        StringBuilder sb = new StringBuilder();

        sb.append(ErrorMessage.ERROR_MESSAGE.getMESSAGE());
        sb.append(ErrorMessage.ERROR_NOT_AVAILABLE_DAY.getMESSAGE());

        return sb.toString();
    }

    // 메뉴 입력받기
    public void bookingMenu() {
        System.out.println(makeBookingMessage());
        String input = Console.readLine();
        List<String> inputSplit = Arrays.stream(input.split("[-|,]")).toList();
        try {
            separate(inputSplit);
        }catch (IllegalArgumentException e) {
            dataClear();
            System.out.println(e);
            bookingMenu();
        }
    }

    public void separate(List<String> inputSplit) {
        for (int i = 0; i < inputSplit.size(); i++) {
            validate(inputSplit.get(i).trim(), i);
        }

        if (checkMenuJustDrink()){
            throw new IllegalArgumentException(makeErrorMessageNotAvailableOrder());
        }
    }

    private void validate(String input, int index) {
        int totalAmount = 0;
        if (index % 2 == 0) {
            addMenu(input);
            return;
        }

        if (index % 2 == 1) {
            addAmount(input);
            totalAmount = inputAmountMenu.stream().mapToInt(Integer::intValue).sum();
            if (totalAmount > 20) {
                throw new IllegalArgumentException(makeErrorMessageNotAvailableOrder());
            }

            return;
        }

        throw new IllegalArgumentException(makeErrorMessageNotAvailableOrder());
    }

    private void addMenu(String input) {
        validateContainMenu(input);
        if (inputMenu.contains(input)) {
            throw new IllegalArgumentException(makeErrorMessageNotAvailableOrder());
        }
        inputMenu.add(input);
    }

    private int addAmount(String input) {
        int amount = validateNumber(input);
        inputAmountMenu.add(amount);

        return amount;
    }

    private void validateContainMenu(String input) {
        Bill bill = new Bill();
        if (!bill.contains(input)) {
            throw new IllegalArgumentException(makeErrorMessageNotAvailableOrder());
        }
    }

    private int validateNumber(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount >= 1) {
                return amount;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(makeErrorMessageNotAvailableOrder());
        }

        throw new IllegalArgumentException(makeErrorMessageNotAvailableOrder());
    }

    private String makeBookingMessage() {
        StringBuilder sb = new StringBuilder();

        sb.append(InputMessage.BOOKING_MENU.getINPUT_MESSAGE());
        sb.append(InputMessage.BOOKING_MENU_EXAMPLE.getINPUT_MESSAGE());

        return sb.toString();
    }

    private String makeErrorMessageNotAvailableOrder() {
        StringBuilder sb = new StringBuilder();

        sb.append(ErrorMessage.ERROR_MESSAGE.getMESSAGE());
        sb.append(ErrorMessage.ERROR_NOT_AVAILABLE_MEBU.getMESSAGE());

        return sb.toString();
    }

    private boolean checkMenuJustDrink() {
        Bill bill = new Bill();
        Drink drink = bill.getDrink();
        return inputMenu.stream()
                .allMatch(i -> drink.getDrink().contains(i));
    }

    private void dataClear() {
        inputMenu.clear();
        inputAmountMenu.clear();
    }

    public List<String> getInputMenu() {
        return inputMenu;
    }

    public List<Integer> getInputAmountMenu() {
        return inputAmountMenu;
    }
}
