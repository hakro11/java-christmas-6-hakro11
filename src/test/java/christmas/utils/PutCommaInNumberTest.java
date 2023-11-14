package christmas.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PutCommaInNumberTest {
    PutCommaInNumber putCommaInNumber = new PutCommaInNumber();

    @Test
    void 메서드_테스트() {
        List<Integer> input = List.of(1_200, 1_000, 150_000, 275_000, 1_000_000);
        List<String> result = List.of("1,200원", "1,000원", "150,000원", "275,000원", "1,000,000원");

        for (int i = 0; i < input.size(); i++) {
            assertThat(putCommaInNumber.putCommaInNumber(input.get(i))).isEqualTo(result.get(i));
        }
    }
}
