package worldcup.model.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Team {
    private final String name;
    private final List<Match> playedMatches;

    public Team(String name, List<Match> playedMatches) {
        this.name = name;
        this.playedMatches = playedMatches;
    }

    private MatchResultCount computeResultCount() {
        Map<MatchResult, Integer> resultCount = new EnumMap<>(MatchResult.class);
        playedMatches.stream()
                .map(this::computeMatchResult)
                .forEach(result -> resultCount.put(result, resultCount.getOrDefault(result, 0) + 1));
        return new MatchResultCount(resultCount);
    }

    private MatchResult computeMatchResult(Match match) {
        return MatchResult.computeResult(match.getSelfScore(name), match.getCounterPartScore(name));
    }

    // TODO 경기 통계 생성

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", playedMatches=" + playedMatches +
                '}';
    }
}
