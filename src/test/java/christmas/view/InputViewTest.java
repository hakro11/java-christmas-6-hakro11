package christmas.view;

import static org.assertj.core.api.Assertions.*;

import christmas.constants.ErrorMessage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class InputViewTest{

    InputView inputView;
    @BeforeEach
    void setUp() {
        this.inputView = new InputView();
    }

    @ParameterizedTest
    @CsvSource({"1","5","10","17","31"})
    void 사용자_입력값_통과_테스트(String day){
        assertThat(inputView.convertStrToInt(day)).isEqualTo(Integer.parseInt(day));
    }

    @ParameterizedTest
    @CsvSource({"영", "삼십", "크리스마스"})
    void 사용자_입력값_에러_Not_Number(String day) {
        assertThatThrownBy(()-> inputView.convertStrToInt(day))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_MESSAGE.getMESSAGE());
    }

    @ParameterizedTest
    @CsvSource({"0", "32", "100"})
    void 사용자_입력값_에러_Not_Correct_Range(String day) {
        int wishDay = Integer.parseInt(day);
        assertThatThrownBy(()-> inputView.checkRange(wishDay))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_MESSAGE.getMESSAGE());
    }
}
