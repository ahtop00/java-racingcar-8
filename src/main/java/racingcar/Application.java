package racingcar;

import racingcar.controller.RacingController;
import racingcar.util.NumberGeneratorUtil;
import racingcar.util.RandomNumberGeneratorUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberGeneratorUtil numberGeneratorUtil = new RandomNumberGeneratorUtil();

        final RacingController racingController = new RacingController(
                inputView,
                outputView,
                numberGeneratorUtil
        );

        racingController.run();
    }
}
