package racingcar.validator;

public class NameInputValidator {
    private NameInputValidator() {
    }

    public static void validateNames(String validInput) {
        String[] names = validInput.split(",", -1);
        for (String name : names) {
            validateSingleName(name);
        }
    }

    private static void validateSingleName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
