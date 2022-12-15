package worldcup.match;

import worldcup.group.Group;
import worldcup.vo.Score;

import java.util.ArrayList;
import java.util.List;

public class MatchRepository {
    private static final List<MatchResult> matchResults = new ArrayList<>();
    public static void save(Group group, Score score, Score anotherScore) {
        matchResults.add(new MatchResult(group, score, anotherScore));
    }
}
