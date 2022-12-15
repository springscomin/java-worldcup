package worldcup.match;

import worldcup.group.Group;
import worldcup.vo.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchRepository {
    private static final List<MatchResult> matchResults = new ArrayList<>();
    public static void save(Group group, Score score, Score anotherScore) {
        matchResults.add(new MatchResult(group, score, anotherScore));
    }

    public static List<MatchResult> findAllByGroup(Group group) {
        return matchResults.stream()
                .filter(matchResult -> matchResult.isGroup(group))
                .collect(Collectors.toList());
    }
}
