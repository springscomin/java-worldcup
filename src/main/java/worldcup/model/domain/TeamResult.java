package worldcup.model.domain;

public class TeamResult implements Comparable<ScoreSummary> {
    private final String teamName;
    private final MatchResultCount matchResultCount;
    private final ScoreSummary scoreSummary;

    public TeamResult(String teamName, MatchResultCount matchResultCount, ScoreSummary scoreSummary) {
        this.teamName = teamName;
        this.matchResultCount = matchResultCount;
        this.scoreSummary = scoreSummary;
    }

    public String getTeamName() {
        return teamName;
    }

    public MatchResultCount getMatchResultCount() {
        return matchResultCount;
    }

    public ScoreSummary getScoreSummary() {
        return scoreSummary;
    }

    @Override
    public String toString() {
        return "TeamResult{" +
                "teamName='" + teamName + '\'' +
                ", matchResultCount=" + matchResultCount +
                ", scoreSummary=" + scoreSummary +
                '}';
    }

    @Override
    public int compareTo(ScoreSummary other) {
        if (scoreSummary.getRankPoint() > other.getRankPoint()) {
            return 1;
        }
        if (scoreSummary.getRankPoint() < other.getRankPoint()) {
            return -1;
        }
        return Integer.compare(scoreSummary.computeTotalGoalDifference(), other.computeTotalGoalDifference());
    }
}
