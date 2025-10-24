package racingcar.validator;

public class NumberInputValidator {
    private NumberInputValidator() {

    }

    public static void validateNumber(String input) {
        int number = parseNumber(input);
        validatePositive(number);
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validatePositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
