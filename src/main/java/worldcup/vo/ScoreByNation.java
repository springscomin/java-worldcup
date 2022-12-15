package worldcup.vo;

import worldcup.nation.Nation;

public class ScoreByNation {
    private final Nation nation;
    private int winningCount;
    private int lostCount;
    private int tieCount;
    /**
     * 승점
     */
    private int point;
    /**
     * 득실차
     */
    private int goalDifference;
    /**
     * 득점
     */
    private int goalCount;

    public ScoreByNation(Nation nation) {
        this.nation = nation;
        this.winningCount = 0;
        this.lostCount = 0;
        this.point = 0;
        this.goalDifference = 0;
        this.goalCount = 0;
    }

    public void addWinningCount() {
        ++winningCount;
    }

    public void addLostCount() {
        ++lostCount;
    }

    public void addTieCount() {
        ++tieCount;
    }

    public void addGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public void addPoints(int countPoint) {
        this.point = countPoint;
    }

    public void addGoalCount(int goalCount) {
        this.goalCount = goalCount;
    }

    public String getNationName() {
        return nation.getName();
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getLostCount() {
        return lostCount;
    }

    public int getTieCount() {
        return tieCount;
    }

    public int getPoint() {
        return point;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public int getGoalCount() {
        return goalCount;
    }
}
