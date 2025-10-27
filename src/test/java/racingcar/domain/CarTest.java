package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("Car 객체 생성 시 이름이 주어지고, 초기 위치는 0이다.")
    void car_객체_생성시_이름과_초기위치_0_설정() {
        //given
        String name = "mori";

        //when
        Car car = new Car(name);

        //then
        assertThat(car.getPosition().getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("move()에 4 이상의 값이 주어지면 전진한다 (위치 1 증가).")
    void move_숫자가_4_이상이면_전진() {
        //given
        Car car = new Car("mori");

        //when
        car.move(4);

        //then
        assertThat(car.getPosition().getValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("move()에 3 이하의 값이 주어지면 멈춘다 (위치 0).")
    void move_숫자가_3_이하면_멈춤() {
        //given
        Car car = new Car("mori");

        //when
        car.move(3);

        //then
        assertThat(car.getPosition().getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("move()를 여러 번 호출 시, 전진/정지 조건에 따라 위치가 누적된다.")
    void move_여러_번_호출시_위치값_누적() {
        //given
        Car car = new Car("mori");

        //when
        car.move(4); // 위치 1
        car.move(2);
        car.move(9); // 위치 2

        // then
        assertThat(car.getPosition().getValue()).isEqualTo(2);
    }
}
