package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.NumberGeneratorUtil;

public class Racing {
    private final List<Car> cars;

    public Racing(String namesInput) {
        this.cars = createCarsFromNames(namesInput);
    }

    public void playRound(NumberGeneratorUtil numberGeneratorUtil) {
        for (Car car : cars) {
            car.move(numberGeneratorUtil.pickNumber());
        }
    }

    public List<String> findWinner() {
        int maxPosition = findMaxPosition();
        return findWinnerAt(maxPosition);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private List<Car> createCarsFromNames(String namesInput) {
        return Arrays.stream(namesInput.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<String> findWinnerAt(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
