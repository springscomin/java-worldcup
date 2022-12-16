package worldcup.model.domain;

public class TeamResult implements Comparable<TeamResult> {
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
    public int compareTo(TeamResult other) {
        return scoreSummary.compareTo(other.scoreSummary);
    }
}
