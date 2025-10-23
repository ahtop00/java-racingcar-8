package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameInputValidatorTest {
    @Test
    @DisplayName("정상적인 이름을 입력시 예외가 발생하지 않는다.")
    void validateNames_정상적인_이름_입력() {
        //given
        String validInput = "Pobi,Jun,Mori";

        //when
        //then
        assertThatCode(() -> NameInputValidator.validateNames(validInput))
                .doesNotThrowAnyException();
    }

    @Test
    void validateNames_이름이_5자를_초과하면_예외_발생() {
        //given
        String validInput = "Pobi,Jun,Moriiiii";

        //when
        //then
        assertThatThrownBy(() -> NameInputValidator.validateNames(validInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNames_이름에_빈_문자열이_있으면_예외_발생() {
        //given
        String validInput = "Pobi,,Mori";

        //when
        //then
        assertThatThrownBy(() -> NameInputValidator.validateNames(validInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNames_이름이_공백만_있으면_예외_발생() {
        //given
        String validInput = "Pobi, ,Mori";

        //when
        //then
        assertThatThrownBy(() -> NameInputValidator.validateNames(validInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
