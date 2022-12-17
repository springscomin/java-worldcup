package worldcup.model.domain;

import java.util.List;
import worldcup.view.constant.ErrorMessage;

public class Team {
    private final String name;
    private final List<Match> playedMatches;

    public Team(String name, List<Match> playedMatches) {
        validateMatches(playedMatches);
        this.name = name;
        this.playedMatches = playedMatches;
    }

    private void validateMatches(List<Match> playedMatches) {
        if (playedMatches.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MATCHES_SIZE);
        }
    }

    public TeamResult computeResult() {
        MatchResultCount matchResultCount = new MatchResultCount(name, playedMatches);
        ScoreSummary scoreSummary = new ScoreSummary(matchResultCount.computeRankPoint(), sumTotalGoals(),
                sumTotalLosingGoals());
        return new TeamResult(name, matchResultCount, scoreSummary);
    }

    private int sumTotalGoals() {
        return playedMatches.stream()
                .map(match -> match.getSelfScore(name))
                .reduce(0, Integer::sum);
    }

    private int sumTotalLosingGoals() {
        return playedMatches.stream()
                .map(match -> match.getCounterPartScore(name))
                .reduce(0, Integer::sum);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", playedMatches=" + playedMatches +
                '}';
    }
}
