package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGeneratorUtil;

public class CarsTest {

    @Test
    void from_문자열로부터_Car_리스트_정상_생성() {
        //given
        String namesInput = "pobi,woni,mori";

        //when
        Cars cars = Cars.from(namesInput);
        List<Car> carList = cars.getCarList();

        //then
        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getName()).isEqualTo("pobi");
        assertThat(carList.get(1).getName()).isEqualTo("woni");
        assertThat(carList.get(2).getName()).isEqualTo("mori");
    }

    @Test
    void moveAll_모든_차_정상_이동() {
        //given
        Cars cars = Cars.from("pobi,woni");

        final int[] index = {0};
        final int[] numbers = {4, 3};
        NumberGeneratorUtil testGenerator = () -> numbers[index[0]++];

        //when
        cars.moveAll(testGenerator);
        List<Car> carList = cars.getCarList();

        //then
        assertThat(carList.get(0).getPosition()).isEqualTo(1);
        assertThat(carList.get(1).getPosition()).isEqualTo(0);
    }

    @Test
    void findWinners_단독_우승자_반환() {
        //given
        Cars cars = Cars.from("pobi,mori");

        //pobi -> 4(전진), mori -> 3(멈춤)
        NumberGeneratorUtil testGenerator1 = () -> 4;
        cars.getCarList().get(0).move(testGenerator1.pickNumber());

        NumberGeneratorUtil testGenerator2 = () -> 3;
        cars.getCarList().get(1).move(testGenerator2.pickNumber());

        //when
        List<String> winners = cars.findWinners();

        //then
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    void findWinners_공동_우승자_반환() {
        //given
        Cars cars = Cars.from("pobi,woni,mori");

        final int[] index = {0};
        final int[] numbers = {5, 3, 5};
        NumberGeneratorUtil testGenerator = () -> numbers[index[0]++];

        //when
        cars.moveAll(testGenerator);
        List<String> winners = cars.findWinners();

        //then
        assertThat(winners).containsExactly("pobi", "mori");
    }

    @Test
    void getCarList_반환된_리스트_수정_불가() {
        //given
        Cars cars = Cars.from("pobi");

        //when
        List<Car> carList = cars.getCarList();

        //then
        assertThatThrownBy(() -> carList.add(new Car("woni")))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
