package racingcar.controller;

import java.util.List;
import racingcar.domain.Racing;
import racingcar.util.NumberGeneratorUtil;
import racingcar.util.RandomNumberGeneratorUtil;
import racingcar.validator.NameInputValidator;
import racingcar.validator.NumberInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGeneratorUtil numberGenerator;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.numberGenerator = new RandomNumberGeneratorUtil();
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

        List<String> winners = racing.findWinner();
        outputView.printWinner(winners);
    }
}
