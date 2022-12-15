package worldcup.outputview;

import worldcup.group.Group;
import worldcup.match.MatchResult;

import java.util.List;

public class MatchResultOutputView {
    public static void printAllMatchResultByGroup(Group group, List<MatchResult> matchResults) {
        System.out.println();
        System.out.println(group.getName());
        for (MatchResult matchResult : matchResults) {
            System.out.printf("%s vs %s %d : %d%n",
                    matchResult.getNationAName(),
                    matchResult.getNationBName(),
                    matchResult.getScoreA(),
                    matchResult.getScoreB());
        }
    }
}
