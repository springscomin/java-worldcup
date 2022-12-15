package worldcup.dto;

import worldcup.group.Group;
import worldcup.match.MatchResult;

import java.util.List;

public class ScoreByNationAndMatchResult {
    private final ScoreByNation score;
    private final List<MatchResult> matchResults;
    private final Group group;
    private final int rank;

    public ScoreByNationAndMatchResult(ScoreByNation score, List<MatchResult> matchResults, Group group, int rank) {
        this.score = score;
        this.matchResults = matchResults;
        this.group = group;
        this.rank = rank;
    }

    public ScoreByNation getScore() {
        return score;
    }

    public List<MatchResult> getMatchResults() {
        return matchResults;
    }

    public int getRank() {
        return rank;
    }

    public String getGroupName() {
        return group.getName();
    }
}
