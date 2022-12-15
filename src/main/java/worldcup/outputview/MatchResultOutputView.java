package worldcup.outputview;

import worldcup.dto.ScoreByNationAndMatchResult;
import worldcup.group.Group;
import worldcup.match.MatchResult;
import worldcup.dto.ScoreByNation;
import worldcup.nation.Nation;

import java.util.List;

public class MatchResultOutputView {

    public static final String ASKING_GROUP_NAME = "출력할 조를 입력하세요 (A ~ H)";
    public static final String MATCH_RESULT_FORMAT = "%s vs %s %d : %d%n";
    public static final String MATCH_RESULT_BY_GROUP_FORMAT
            = "승 : %d, 무 : %d, 패 : %d, 승점 : %d, 득실차 : %d, 득점 : %d%n";
    public static final String ASKING_NATION_NAME = "출력할 국가를 입력하세요 (월드컵 출전 국가)";
    public static final String MATCH_RESULT_BY_GROUP_RANK_FORMAT = "%d위 %s, ";
    public static final int WINNING_CUTLINE = 2;
    public static final String GOING_NEXT_SUCCEED_FORMAT = "%s %d로 16강 진출에 성공했습니다.%n";
    public static final String GOING_NEXT_FAILED_FORMAT = "%s %d로 16강 진출에 실패했습니다.%n";

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

    public static void printAskingNationName() {
        System.out.println();
        System.out.println(ASKING_NATION_NAME);
    }

    public static void printMatchResultByNation(Nation nation, ScoreByNationAndMatchResult score) {
        System.out.println();
        System.out.println(nation.getName());
        printResultByScoreByNation(score.getScore());

        System.out.println();
        for (MatchResult matchResult : score.getMatchResults()) {
            printResultByMatchResult(matchResult);
        }

        printNationGoingNextOrNotMessage(score);
        System.out.println(CommonConstant.LINE_SEPARATOR.getText());
    }

    private static void printNationGoingNextOrNotMessage(ScoreByNationAndMatchResult score) {
        System.out.println();
        if (score.getRank() <= WINNING_CUTLINE) {
            System.out.printf(GOING_NEXT_SUCCEED_FORMAT, score.getGroupName(), score.getRank());
        }
        if (WINNING_CUTLINE < score.getRank()) {
            System.out.printf(GOING_NEXT_FAILED_FORMAT, score.getGroupName(), score.getRank());
        }
    }

    private static void printResultsByScoreByNation(List<ScoreByNation> scores) {
        for (int rank = 0; rank < scores.size(); rank++) {
            ScoreByNation score = scores.get(rank);
            System.out.printf(MATCH_RESULT_BY_GROUP_RANK_FORMAT, rank + 1, score.getNationName());
            printResultByScoreByNation(score);
        }
    }

    private static void printResultByScoreByNation(ScoreByNation score) {
        System.out.printf(MATCH_RESULT_BY_GROUP_FORMAT,
                score.getWinningCount(), score.getTieCount(), score.getLostCount(),
                score.getPoint(), score.getGoalDifference(), score.getGoalCount());
    }

    private static void printResultsByMatchResult(List<MatchResult> matchResults) {
        for (MatchResult matchResult : matchResults) {
            printResultByMatchResult(matchResult);
        }
    }

    private static void printResultByMatchResult(MatchResult matchResult) {
        System.out.printf(MATCH_RESULT_FORMAT,
                matchResult.getNationAName(),
                matchResult.getNationBName(),
                matchResult.getScoreA(),
                matchResult.getScoreB());
    }
}
