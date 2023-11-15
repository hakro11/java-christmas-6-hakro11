package christmas.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DiscountTest {
    Discount discount;

    @BeforeEach
    void setUp() {
        this.discount = new Discount();
    }

    @DisplayName("크리스마스 디데이 할인 적용 확인")
    @ParameterizedTest
    @CsvSource({"1,1000", "2,1100", "5, 1400", "25, 3400", "26, 0", "31, 0"})
    void d_day_discount(int input, int expect) {
        assertThat(discount.d_dayDiscount(input)).isEqualTo(expect);
    }

    @DisplayName("주말, 평일 할인 적용 확인")
    @ParameterizedTest
    @CsvSource({"0,0", "1,2023", "2,4046", "10,20230", "15, 30345"})
    void 주말or평일_할인_적용_확인(int menuAmount, int expect) {
        discount.weekdayDiscount(menuAmount);
        discount.weekendDiscount(menuAmount);
        int actual1 = discount.getWeekend();
        int actual2 = discount.getWeekday();

        assertThat(actual1).isEqualTo(expect);
        assertThat(actual2).isEqualTo(expect);
    }

    @DisplayName("스페셜 할인 리턴값 확인")
    @Test
    void check_special() {
        discount.specialDiscount();
        int acutal = discount.getSpecial();
        int result = 1000;

        assertThat(acutal).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"120000,25000", "119999,0", "250000,25000"})
    void 샴페인_증정_확인 (int input, int expect) {
        int 기준가격 = 120_000;
        int actual = input;
        int result = 0;

        if (actual >= 기준가격) {
            discount.giftEvent();
            result = discount.getGift();
        }

        assertThat(result).isEqualTo(expect);
    }
}
