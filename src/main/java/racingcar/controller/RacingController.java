package racingcar.controller;

import java.util.List;
import racingcar.domain.Racing;
import racingcar.util.NumberGeneratorUtil;
import racingcar.validator.NameInputValidator;
import racingcar.validator.NumberInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    InputView inputView;
    OutputView outputView;
    NumberGeneratorUtil numberGenerator;

    public RacingController(InputView inputView, OutputView outputView, NumberGeneratorUtil numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        String namesInput = inputView.readNames();
        NameInputValidator.validateNames(namesInput);

        String countInput = inputView.readAttemptCount();
        NumberInputValidator.validateNumber(countInput);
        int count = Integer.parseInt(countInput);

        Racing racing = new Racing(namesInput);

        outputView.printRoundResultHeader();
        for (int i = 0; i < count; i++) {
            racing.playRound(numberGenerator);
            outputView.printRoundResult(racing.getCars());
        }

        List<String> winners = racing.findWinners();
        outputView.printWinner(winners);
    }
}
