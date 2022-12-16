package worldcup.model.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class MatchResultCount {
    private final Map<MatchResult, Integer> resultCount = new EnumMap<>(MatchResult.class);

    public MatchResultCount(String teamName, List<Match> playedMatches) {
        initialize();
        computeResultCount(teamName, playedMatches);
    }

    private void initialize() {
        Arrays.stream(MatchResult.values())
                .forEach(result -> this.resultCount.put(result, 0));
    }

    private void computeResultCount(String teamName, List<Match> playedMatches) {
        playedMatches.stream()
                .map(match -> computeMatchResult(teamName, match))
                .forEach(result -> resultCount.put(result, resultCount.getOrDefault(result, 0) + 1));
    }

    private MatchResult computeMatchResult(String teamName, Match match) {
        return MatchResult.computeResult(match.getSelfScore(teamName), match.getCounterPartScore(teamName));
    }

    public int computeRankPoint() {
        int winCount = resultCount.get(MatchResult.WIN);
        int drawCount = resultCount.get(MatchResult.DRAW);
        return (winCount * 3) + drawCount;
    }

    @Override
    public String toString() {
        return "MatchResultCount{" +
                "resultCount=" + resultCount +
                '}';
    }
}
