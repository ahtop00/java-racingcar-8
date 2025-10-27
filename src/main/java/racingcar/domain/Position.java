package racingcar.domain;

public class Position {
    private int value;

    public Position() {
        this.value = 0;
    }

    public void move() {
        this.value++;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isFurtherThan(Position other) {
        return this.value > other.getValue();
    }

    public boolean equals(Position other) {
        return this.value == other.getValue();
    }
}
