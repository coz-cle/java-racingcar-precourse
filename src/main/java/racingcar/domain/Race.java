package racingcar.domain;

public class Race {

    private final int roundCount;

    public Race(
            final int roundCount
    ) {
        this.roundCount = roundCount;
    }

    public static Race of(
            final String tryCount
    ) {
        return new Race(Integer.parseInt(tryCount));
    }

    public int getRoundCount() {
        return roundCount;
    }

}
