package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"\n", "", "\t", "\r\n"})
    @DisplayName("당첨 번호가 비어있으면 예외가 발생한다.")
    void validateWinningNumbersIsNotEmpty(String condition) {
        assertThatThrownBy(() -> WinningNumbers.from(condition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 비어있을 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1;2;3", "1a2a3", "1.2.3"})
    @DisplayName("당첨 번호의 구분자가 쉼표가 아니면 예외가 발생한다.")
    void validateWinningNumbersDelimiter(String condition) {
        assertThatThrownBy(() -> WinningNumbers.from(condition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분합니다.");
    }

}