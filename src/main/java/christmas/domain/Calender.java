package christmas.domain;

import christmas.constants.Const;
import java.util.HashMap;
import java.util.Map;

public class Calender {
    private final int DAY_START = 1;
    private final int DAY_LAST = 31;
    private final int FRIDAY = 1;
    private final int SATURDAY = 2;
    private final int SPECIALDAY = 3;
    private final int DAY_OF_WEEK = 7;
    private final int CHRISTMAS = 25;


    private final Map<Integer, String> eventCalender;

    public Calender(Map<Integer, String> eventCalender) {
        this.eventCalender = setCalender();
    }

    public Map<Integer, String> getEventCalender() {
        return eventCalender;
    }

    private Map<Integer, String> setCalender() {
        Map<Integer, String> calender = new HashMap<>();

        for (int i = DAY_START; i <= DAY_LAST; i++) {
            makeEvent(i, calender);
        }
        return calender;
    }

    private void makeEvent(int day, Map<Integer, String> calender) {
        if (day % DAY_OF_WEEK == FRIDAY || day % DAY_OF_WEEK == SATURDAY) {
            calender.put(day, String.valueOf(Const.WEEKEND));
            return;
        }

        if (day % DAY_OF_WEEK == SPECIALDAY || day == CHRISTMAS) {
            calender.put(day, String.valueOf(Const.SPECIAL));
            return;
        }

        calender.put(day, String.valueOf(Const.WEEKDAY));
    }
}
