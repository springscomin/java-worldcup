package worldcup.model.domain;

public class TeamResult {
    private final MatchResultCount matchResultCount;
    private final ScoreSummary scoreSummary;

    public TeamResult(MatchResultCount matchResultCount, int totalLosingGoals, int totalGoals) {
        this.matchResultCount = matchResultCount;
        int rankPoint = matchResultCount.computeRankPoint();
        this.scoreSummary = new ScoreSummary(rankPoint, totalLosingGoals, totalGoals);
    }
}
