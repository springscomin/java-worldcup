package worldcup.vo;

import worldcup.nation.Nation;

import java.util.Objects;

public class Score {
    private final Nation nation;
    private final Integer nationScore;

    public Score(Nation nation, Integer nationScore) {
        this.nation = nation;
        this.nationScore = nationScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "nation=" + nation +
                ", nationScore=" + nationScore +
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
        Score score = (Score) o;
        return nation.equals(score.nation) && nationScore.equals(score.nationScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nation, nationScore);
    }
}
