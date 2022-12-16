package worldcup.model.domain;

public class ScoreSummary {
    private final int rankPoint;
    private final int totalLosingGoals;
    private final int totalGoals;

    public ScoreSummary(int rankPoint, int totalLosingGoals, int totalGoals) {
        this.rankPoint = rankPoint;
        this.totalLosingGoals = totalLosingGoals;
        this.totalGoals = totalGoals;
    }

    public int getRankPoint() {
        return rankPoint;
    }

    public int getTotalGoals() {
        return totalGoals;
    }

    public int computeTotalGoalDifference() {
        return totalGoals - totalLosingGoals;
    }

    @Override
    public String toString() {
        return "ScoreSummary{" +
                "rankPoint=" + rankPoint +
                ", totalLosingGoals=" + totalLosingGoals +
                ", totalGoals=" + totalGoals +
                '}';
    }
}
