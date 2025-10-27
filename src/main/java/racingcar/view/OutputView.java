package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String MSG_RESULT_HEADER = "\n실행 결과";
    private static final String MSG_WINNER = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";
    private static final String POSITION_MARK = "-";

    public void printRoundResultHeader() {
        System.out.println(MSG_RESULT_HEADER);
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(formatCarPosition(car));
        }
        System.out.println();
    }

    private String formatCarPosition(Car car) {
        String name = car.getName();
        String position = POSITION_MARK.repeat(car.getPosition());
        return name + " : " + position;
    }

    public void printWinner(List<String> winners) {
        String winnersNames = String.join(WINNER_DELIMITER, winners);
        System.out.print(MSG_WINNER + winnersNames);
    }
}
