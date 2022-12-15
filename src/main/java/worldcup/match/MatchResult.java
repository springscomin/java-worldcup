package worldcup.match;

import worldcup.group.Group;
import worldcup.vo.Score;

import java.util.Objects;

public class MatchResult {
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
}
