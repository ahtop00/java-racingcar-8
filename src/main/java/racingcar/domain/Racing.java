package racingcar.domain;

import java.util.List;
import racingcar.util.NumberGeneratorUtil;

public class Racing {
    private final Cars cars;

    public Racing(String namesInput) {
        this.cars = Cars.from(namesInput);
    }

    public void playRound(NumberGeneratorUtil numberGenerator) {
        cars.moveAll(numberGenerator);
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }

    public List<Car> getCars() {
        return cars.getCarList();
    }
}
