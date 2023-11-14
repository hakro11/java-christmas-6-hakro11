package christmas.view;

import static org.assertj.core.api.Assertions.*;

import christmas.constants.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class InputViewTest {

    InputView inputView;

    @BeforeEach
    void setUp() {
        this.inputView = new InputView();
    }

    @ParameterizedTest
    @CsvSource({"1", "5", "10", "17", "31"})
    void 날짜입력_사용자_입력값_통과_테스트(String day) {
        assertThat(inputView.convertStrToInt(day)).isEqualTo(Integer.parseInt(day));
    }

    @ParameterizedTest
    @CsvSource({"영", "삼십", "크리스마스"})
    void 날짜입력_사용자_입력값_에러_Not_Number(String day) {
        assertThatThrownBy(() -> inputView.convertStrToInt(day))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_MESSAGE.getMESSAGE());
    }

    @ParameterizedTest
    @CsvSource({"0", "32", "100"})
    void 날짜입력_사용자_입력값_에러_Not_Correct_Range(String day) {
        int wishDay = Integer.parseInt(day);
        assertThatThrownBy(() -> inputView.checkRange(wishDay))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_MESSAGE.getMESSAGE());
    }

    @Test
    void 메뉴주문_사용자_입력값_통과() {
        String input = "양송이수프-2, 티본스테이크-2, 해산물파스타-1, 초코케이크-1, 레드와인-1, 샴페인-1";
        List<String> result1 = List.of("양송이수프", "티본스테이크", "해산물파스타", "초코케이크", "레드와인", "샴페인");
        List<Integer> result2 = List.of(2, 2, 1, 1, 1, 1);
        List<String> inputSplit = Arrays.stream(input.split("[-|,]")).toList();
        inputView.separate(inputSplit);

        assertThat(inputView.getInputMenu()).isEqualTo(result1);
        assertThat(inputView.getInputAmountMenu()).isEqualTo(result2);
    }

    void 에러_메서드(String input) {
        List<String> inputSplit = Arrays.stream(input.split("[-|,]")).toList();

        assertThatThrownBy(() -> inputView.separate(inputSplit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_MESSAGE.getMESSAGE());
    }

    @DisplayName("메뉴 이름을 중복 입력 했을때의 케이스")
    @Test
    void 메뉴주문_사용자_입력값_에러_중복메뉴() {
        String input = "양송이수프-2, 티본스테이크-2, 양송이수프-1, 초코케이크-1, 레드와인-1, 샴페인-1";
        에러_메서드(input);
    }

    @DisplayName("입력한 메뉴의 구성이 음료로만 구성되어 있을때의 케이스")
    @Test
    void 메뉴주문_사용자_입력값_에러_음료만주문() {
        String input = "제로콜라-2, 레드와인-1, 샴페인-2";
        에러_메서드(input);
    }

    @DisplayName("입력한 메뉴의 개수가 20개를 초과하는 경우")
    @Test
    void 메뉴주문_사용자_입력값_에러_메뉴_초과() {
        String input = "양송이수프-5, 타파스-5, 티본스테이크-4, 바비큐립-4, 레드와인-1, 샴페인-1, 초코케이크-1";
        에러_메서드(input);
    }

    @DisplayName("입력한 메뉴가 메뉴판에 없는경우")
    @Test
    void 메뉴주문_사용자_입력값_에러_존재하지_않는_메뉴() {
        String input = "시저샐러드-2, 로제파스타-3, 제로콜라-1";

        에러_메서드(input);
    }

    @DisplayName("잘못된 양식의 입력값")
    @ParameterizedTest
    @CsvSource({
            "5-초코케이크,3-바비큐립,1-제로콜라",
            "초코케이크-다섯개,바비큐립-세개, 제로콜라-한개",
            "초코케이크_5,바비큐립_3,제로콜라_1",
            "초코케이크+5,바비큐립+3,제로콜라+1"
    })
    void 메뉴주문_사용자_입력값_에러_잘못된_양식의_입력(String input) {
        에러_메서드(input);
    }
}
