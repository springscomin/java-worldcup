package worldcup.model.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class MatchResultCount {
    private final Map<MatchResult, Integer> resultCount = new EnumMap<>(MatchResult.class);

    public MatchResultCount(Map<MatchResult, Integer> resultCount) {
        initialize();
        resultCount.keySet()
                .forEach(result -> this.resultCount.put(result, resultCount.get(result)));
    }

    private void initialize() {
        Arrays.stream(MatchResult.values())
                .forEach(result -> this.resultCount.put(result, 0));
    }

    @Override
    public String toString() {
        return "MatchResultCount{" +
                "resultCount=" + resultCount +
                '}';
    }
}
