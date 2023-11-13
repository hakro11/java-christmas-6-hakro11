package christmas.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalendarTest {
    private Map<Integer, String> calendar;

    @BeforeEach
    void setUp() {
        Calendar calendar = new Calendar();
        this.calendar = calendar.getEventCalendar();
    }

    @ParameterizedTest
    @CsvSource({"1,Weekend", "2,Weekend", "25,Special", "25,Weekday", "10,Special", "31,Special", "30,Weekend", "12,Weekday"})
    public void checkDay(int day, String expected) {
        assertThat(calendar.get(day)).contains(expected);

    }
}
