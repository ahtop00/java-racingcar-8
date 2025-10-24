package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NameInputValidatorTest {
    @Test
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
        String invalidInput = "Pobi,Jun,Moriiiii";

        //when
        //then
        assertThatThrownBy(() -> NameInputValidator.validateNames(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNames_이름에_빈_문자열이_있으면_예외_발생() {
        //given
        String invalidInput = "Pobi,,Mori";

        //when
        //then
        assertThatThrownBy(() -> NameInputValidator.validateNames(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNames_이름이_공백만_있으면_예외_발생() {
        //given
        String invalidInput = "Pobi, ,Mori";

        //when
        //then
        assertThatThrownBy(() -> NameInputValidator.validateNames(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNames_정상적인_숫자_혼용_이름_입력() {
        //given
        String validInput = "Pobi,Jun,Mori2";

        //when
        //then
        assertThatCode(() -> NameInputValidator.validateNames(validInput))
                .doesNotThrowAnyException();
    }

    @Test
    void validateNames_잘못된_구분자_사용시_예외_발생() {
        //given
        String invalidInput = "Pobi.Jun.Mori";

        //when
        //then
        assertThatThrownBy(() -> NameInputValidator.validateNames(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNames_특수문자_포함_5자_이내_입력() {
        //given
        String validInput = "a.b";

        //when
        //then
        assertThatCode(() -> NameInputValidator.validateNames(validInput))
                .doesNotThrowAnyException();
    }

    @Test
    void validateNames_쉼표로_끝나면_예외_발생() {
        //given
        String invalidInput = "Pobi,Mori,";

        //when
        //then
        assertThatThrownBy(() -> NameInputValidator.validateNames(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
