package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NumberInputValidatorTest {
    @Test
    void validateNumber_정상적인_숫자_입력() {
        //given
        String validInput = "5";

        //when
        //then
        assertThatCode(() -> NumberInputValidator.validateNumber(validInput))
                .doesNotThrowAnyException();
    }

    @Test
    void validateNumber_숫자가_아닌_값이_있으면_예외_발생() {
        //given
        String invalidInput = "10a";

        //when
        //then
        assertThatThrownBy(() -> NumberInputValidator.validateNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void validateNumber_입력값이_0이면_예외_발생() {
        //given
        String invalidInput = "0";

        //when
        //then
        assertThatThrownBy(() -> NumberInputValidator.validateNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNumber_입력값이_음수면_예외_발생() {
        //given
        String invalidInput = "-2";

        //when
        //then
        assertThatThrownBy(() -> NumberInputValidator.validateNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNumber_입력값이_빈_문자열이면_예외_발생() {
        //given
        String invalidInput = "";

        //when
        //then
        assertThatThrownBy(() -> NumberInputValidator.validateNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNumber_입력값이_공백만_있으면_예외_발생() {
        //given
        String invalidInput = " ";

        //when
        //then
        assertThatThrownBy(() -> NumberInputValidator.validateNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNumber_숫자_앞이나_뒤에_공백이_있으면_예외_발생() {
        //given
        String invalidInput = " 5";

        //when
        //then
        assertThatThrownBy(() -> NumberInputValidator.validateNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNumber_소수점이_포함되면_예외_발생() {
        //given
        String invalidInput = "5.4";

        //when
        //then
        assertThatThrownBy(() -> NumberInputValidator.validateNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}


