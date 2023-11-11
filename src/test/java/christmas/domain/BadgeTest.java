package christmas.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BadgeTest {
    @ParameterizedTest
    @CsvSource({"4999,없음","5000,별", "7500,별", "9999,별", "10000,트리", "19999,트리", "20000,산타"})
    void 메서드_테스트(int totalDiscountPrice, String expected) {
        Badge badge = new Badge(totalDiscountPrice);
        String reslut = badge.getBADGE();
        assertThat(reslut).isEqualTo(expected);
    }
}
