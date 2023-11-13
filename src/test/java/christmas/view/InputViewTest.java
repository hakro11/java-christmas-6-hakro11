package christmas.view;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

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

    }
}
