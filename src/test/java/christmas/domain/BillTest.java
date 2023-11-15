package christmas.domain;

import static org.assertj.core.api.Assertions.*;

import christmas.view.InputView;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BillTest {
    Bill bill;

    @BeforeEach
    void setUp() {
        this.bill = new Bill();
    }

    @ParameterizedTest
    @CsvSource({
            "양송이수프", "타파스", "시저샐러드",    // 애피타이저
            "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타", //메인
            "초코케이크", "아이스크림",   //디저트
            "제로콜라", "레드와인", "샴페인"   //음료
    })
    void 메서드_정상_작동_메뉴_확인(String input) {
        assertThat(bill.contains(input)).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource({"양송이스프", "샐러드", "스테이크", "초코케익", "콜라"})
    void 메서드_정상_작동_잘못된_메뉴(String input) {
        assertThat(bill.contains(input)).isEqualTo(false);
    }

    @DisplayName("사용자 입력 메뉴 적용 확인")
    @Test
    void 메뉴_적용하기() {
        List<String> inputMenu = List.of("타파스", "티본스테이크", "아이스크림", "샴페인");
        List<Integer> inputAmount = List.of(2,2,2,1);
        InputView inputView = new InputView();
        int result = 156_000;

        inputView.setInputMenu(inputMenu);
        inputView.setInputAmountMenu(inputAmount);
        bill.applyMenu(inputView);

        assertThat(bill.getTotalPriceBeforeDiscount()).isEqualTo(result);
    }
}
