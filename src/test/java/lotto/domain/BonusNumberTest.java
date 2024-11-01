package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"\n", "", "\t", "\r\n"})
    @DisplayName("보너스 번호가 비어있으면 예외가 발생한다.")
    void validateWinningNumbersIsNotEmpty(String condition) {
        assertThatThrownBy(() -> BonusNumber.from(condition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 비어있을 수 없습니다.");
    }

}