package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.NumberGeneratorUtil;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String namesInput) {
        List<Car> cars = Arrays.stream(namesInput.split(","))
                .map(String::trim)
                .map(Car::new)
                .toList();

        return new Cars(cars);
    }

    public void moveAll(NumberGeneratorUtil numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.pickNumber());
        }
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return findWinnerAt(maxPosition);
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

    public List<Car> getCarList() {
        return Collections.unmodifiableList(cars);
    }
}
