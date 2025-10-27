package racingcar.domain;

public class Car {
    private static final int MOVE_FORWARD_THRESHOLD = 4;

    private final String name;
    private final Position position;

    public Car(String name) {
        this.name = name;
        this.position = new Position();
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= MOVE_FORWARD_THRESHOLD) {
            position.move();
        }
    }
}
