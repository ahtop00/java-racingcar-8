package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void position_객체_생성시_초기값은_0() {
        //given
        Position position = new Position();

        //when
        int value = position.getValue();

        //then
        assertThat(value).isEqualTo(0);
    }

    @Test
    void move_메서드_호출시_값이_1_증가() {
        //given
        Position position = new Position();

        //when
        position.move();

        //then
        assertThat(position.getValue()).isEqualTo(1);
    }

    @Test
    void move_메서드_여러번_호출시_값이_누적() {
        //given
        Position position = new Position();

        //when
        position.move();
        position.move();
        position.move();

        //then
        assertThat(position.getValue()).isEqualTo(3);
    }

    @Test
    void isFurtherThan_비교대상이_작을경우_true를_반환() {
        //given
        Position position1 = new Position();
        position1.move();
        Position position2 = new Position();

        //when
        boolean result = position1.isFurtherThan(position2);

        //then
        assertThat(result).isTrue();
    }

    @Test
    void isFurtherThan_비교대상이_같을경우_false를_반환() {
        //given
        Position position1 = new Position();
        position1.move();
        Position position2 = new Position();
        position2.move();

        //when
        boolean result = position1.isFurtherThan(position2);

        //then
        assertThat(result).isFalse();
    }

    @Test
    void isFurtherThan_비교대상이_클경우_false를_반환() {
        //given
        Position position1 = new Position();
        Position position2 = new Position();
        position2.move();

        //when
        boolean result = position1.isFurtherThan(position2);

        //then
        assertThat(result).isFalse();
    }
}
