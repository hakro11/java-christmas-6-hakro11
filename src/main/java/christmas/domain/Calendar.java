package christmas.domain;

import christmas.constants.Const;
import java.util.HashMap;
import java.util.Map;

public class Calendar {
    private final int DAY_START = 1;
    private final int DAY_LAST = 31;
    private final int FRIDAY = 1;
    private final int SATURDAY = 2;
    private final int SPECIALDAY = 3;
    private final int DAY_OF_WEEK = 7;
    private final int CHRISTMAS = 25;
    private final Map<Integer, String> eventCalendar;

    public Calendar() {
        this.eventCalendar = setCalendar();
    }

    public Map<Integer, String> getEventCalendar() {
        return eventCalendar;
    }

    private Map<Integer, String> setCalendar() {
        Map<Integer, String> calendar = new HashMap<>();

        for (int i = DAY_START; i <= DAY_LAST; i++) {
            makeEvent(i, calendar);
        }

        return calendar;
    }

    private void makeEvent(int day, Map<Integer, String> calendar) {
        int selectDay = day % DAY_OF_WEEK;
        if (selectDay == FRIDAY || selectDay == SATURDAY) {
            calendar.put(day, String.valueOf(Const.WEEKEND));
            return;
        }

        if (selectDay == SPECIALDAY || day == CHRISTMAS) {
            calendar.put(day, String.valueOf(Const.SPECIAL));
            return;
        }

        calendar.put(day, String.valueOf(Const.WEEKDAY));
    }
}
