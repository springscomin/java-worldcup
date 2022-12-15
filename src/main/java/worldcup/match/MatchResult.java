package worldcup.match;

import worldcup.group.Group;
import worldcup.vo.Score;

import java.util.Objects;

public class MatchResult {
    private final Group group;
    private final Score score;
    private final Score anotherScore;

    public MatchResult(Group group, Score score, Score anotherScore) {
        this.group = group;
        this.score = score;
        this.anotherScore = anotherScore;
    }

    @Override
    public String toString() {
        return "MatchResult{" +
                "group=" + group +
                ", score=" + score +
                ", anotherScore=" + anotherScore +
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
        return group.equals(that.group) && score.equals(that.score) && anotherScore.equals(that.anotherScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, score, anotherScore);
    }
}
