package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGeneratorUtil;

public class RacingTest {

    private Racing racing;
    private final String carNames = "pobi,woni,mori";

    @BeforeEach
    void setUp() {
        racing = new Racing(carNames);
    }

    @Test
    @DisplayName("Racing 객체 생성 시 자동차들이 정상 생성된다.")
    void racing_객체_생성시_자동차들_정상_생성() {
        //given

        //when
        List<Car> cars = racing.getCars();

        //then
        assertThat(cars).hasSize(3);
        assertThat(cars)
                .map(Car::getName)
                .containsExactly("pobi", "woni", "mori");
    }

    @Test
    @DisplayName("playRound 1회 실행 시 자동차들이 정상 이동 및 정지한다.")
    void playRound_1회_실행시_자동차들_정상_이동() {
        //given
        final int[] index = {0};
        final int[] numbers = {4, 3, 5}; //pobi:전진, woni:멈춤, mori:전진
        NumberGeneratorUtil testGenerator = () -> numbers[index[0]++];

        //when
        racing.playRound(testGenerator);
        List<Car> cars = racing.getCars();

        //then
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(0);
        assertThat(cars.get(2).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("findWinner가 단독 우승자를 정확히 찾아낸다.")
    void findWinners_단독_우승자_테스트() {
        //given
        //(pobi: 4, 4 = 2 / woni: 3, 3 = 0 / mori: 4, 3 = 1)
        final int[] index = {0};
        final int[] numbers = {4, 3, 4, 4, 3, 3};
        NumberGeneratorUtil testGenerator = () -> numbers[index[0]++];

        //when
        racing.playRound(testGenerator);
        racing.playRound(testGenerator);

        List<String> winners = racing.findWinners();

        //then
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    @DisplayName("findWinner가 공동 우승자를 정확히 찾아낸다.")
    void findWinners_공동_우승자_테스트() {
        //given
        //(pobi: 4, 3 = 1 / woni: 3, 4 = 1 / mori: 3, 3 = 0)
        final int[] index = {0};
        final int[] numbers = {4, 3, 3, 3, 4, 3};
        NumberGeneratorUtil testGenerator = () -> numbers[index[0]++];

        //when
        racing.playRound(testGenerator);
        racing.playRound(testGenerator);
        List<String> winners = racing.findWinners();

        //then
        assertThat(winners).containsExactly("pobi", "woni");
    }
}

