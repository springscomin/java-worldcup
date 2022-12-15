package worldcup.match;

import worldcup.group.Group;
import worldcup.nation.Nation;
import worldcup.vo.GameResult;
import worldcup.vo.Score;

import java.util.List;
import java.util.Objects;

public class MatchResult {
    public static final String INVALID_NATION_VALUE = "경기 결과에 해당하지 않는 팀 이름";
    private final Group group;
    private final Score scoreA;
    private final Score scoreB;

    public MatchResult(Group group, Score scoreA, Score scoreB) {
        this.group = group;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }

    public boolean isGroup(Group group) {
        return this.group.equals(group);
    }

    public String getNationAName() {
        return scoreA.getNationName();
    }

    public String getNationBName() {
        return scoreB.getNationName();
    }

    public int getScoreA() {
        return scoreA.getScore();
    }

    public int getScoreB() {
        return scoreB.getScore();
    }

    @Override
    public String toString() {
        return "MatchResult{" +
                "group=" + group +
                ", scoreA=" + scoreA +
                ", scoreB=" + scoreB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MatchResult that = (MatchResult) o;
        return group.equals(that.group) && scoreA.equals(that.scoreA) && scoreB.equals(that.scoreB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, scoreA, scoreB);
    }

    public List<Nation> getNations() {
        return List.of(
                scoreA.getNation(),
                scoreB.getNation()
        );
    }

    public boolean hasNation(Nation nation) {
        return scoreA.isNation(nation) || scoreB.isNation(nation);
    }

    public GameResult getGameResultOf(Nation nation) {
        if (scoreA.isNation(nation)) {
            return compareScore(scoreA, scoreB);
        }
        if (scoreB.isNation(nation)) {
            return compareScore(scoreB, scoreA);
        }
        throw new IllegalArgumentException(INVALID_NATION_VALUE);
    }

    private GameResult compareScore(Score target, Score competitor) {
        if (target.higherThan(competitor)) {
            return GameResult.WIN;
        }
        if (target.lowerThan(competitor)) {
            return GameResult.LOSE;
        }
        return GameResult.TIE;
    }

    public int getGoalDifference(Nation nation) {
        if (scoreA.isNation(nation)) {
            return scoreA.getScore() - scoreB.getScore();
        }
        if (scoreB.isNation(nation)) {
            return scoreB.getScore() - scoreA.getScore();
        }
        throw new IllegalArgumentException(INVALID_NATION_VALUE);
    }

    public int goalCount(Nation nation) {
        if (scoreA.isNation(nation)) {
            return scoreA.getScore();
        }
        if (scoreB.isNation(nation)) {
            return scoreB.getScore();
        }
        throw new IllegalArgumentException(INVALID_NATION_VALUE);
    }
}
