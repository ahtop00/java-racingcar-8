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
            throw new IllegalArgumentException("이름은 빈칸일 수 없습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5글자가 최대입니다.");
        }
    }
}
