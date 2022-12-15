package worldcup.outputview;

import worldcup.group.Group;
import worldcup.match.MatchResult;
import worldcup.vo.ScoreByNation;

import java.util.List;

public class MatchResultOutputView {

    public static final String ASKING_GROUP_NAME = "출력할 조를 입력하세요 (A ~ H)";
    public static final String MATCH_RESULT_FORMAT = "%s vs %s %d : %d%n";
    public static final String MATCH_RESULT_BY_GROUP_FORMAT
            = "%d위 %s, 승 : %d, 무 : %d, 패 : %d, 승점 : %d, 득실차 : %d, 득점 : %d%n";

    public static void printAllMatchResultByGroup(Group group, List<MatchResult> matchResults) {
        System.out.println();
        System.out.println(group.getName());
        printResultsByMatchResult(matchResults);
        System.out.println(CommonConstant.LINE_SEPARATOR.getText());
    }

    public static void printAskingGroupName() {
        System.out.println();
        System.out.println(ASKING_GROUP_NAME);
    }

    public static void printMatchResultsByGroup(Group group, List<ScoreByNation> scores) {
        System.out.println();
        System.out.println(group.getName());
        printResultsByScoreByNation(scores);
        System.out.println(CommonConstant.LINE_SEPARATOR.getText());
    }

    private static void printResultsByScoreByNation(List<ScoreByNation> scores) {
        for (int rank = 0; rank < scores.size(); rank++) {
            ScoreByNation score = scores.get(rank);
            System.out.printf(MATCH_RESULT_BY_GROUP_FORMAT,
                    rank + 1,
                    score.getNationName(),
                    score.getWinningCount(), score.getTieCount(), score.getLostCount(),
                    score.getPoint(), score.getGoalDifference(), score.getGoalCount());
        }
    }

    private static void printResultsByMatchResult(List<MatchResult> matchResults) {
        for (MatchResult matchResult : matchResults) {
            System.out.printf(MATCH_RESULT_FORMAT,
                    matchResult.getNationAName(),
                    matchResult.getNationBName(),
                    matchResult.getScoreA(),
                    matchResult.getScoreB());
        }
    }
}
