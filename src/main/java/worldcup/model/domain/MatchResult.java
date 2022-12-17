package worldcup.model.domain;

import java.util.Arrays;
import java.util.function.BiFunction;
import worldcup.view.constant.ErrorMessage;

public enum MatchResult {
    WIN((selfScore, counterScore) -> selfScore > counterScore),
    DRAW((selfScore, counterScore) -> selfScore == counterScore),
    LOSE((selfScore, counterScore) -> selfScore < counterScore);

    private final BiFunction<Integer, Integer, Boolean> condition;

    MatchResult(BiFunction<Integer, Integer, Boolean> condition) {
        this.condition = condition;
    }

    public static MatchResult computeResult(int selfScore, int counterScore) {
        return Arrays.stream(values())
                .filter(value -> value.condition.apply(selfScore, counterScore))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.MATCH_RESULT_NOT_FOUND));
    }
}
