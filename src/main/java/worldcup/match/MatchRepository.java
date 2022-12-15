package worldcup.match;

import worldcup.group.Group;
import worldcup.nation.Nation;
import worldcup.vo.GameResult;
import worldcup.vo.Score;
import worldcup.dto.ScoreByNation;

import java.util.ArrayList;
import java.util.HashSet;
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

    public static List<Nation> findAllNationsByGroup(Group group) {
        HashSet<Nation> nations = new HashSet<>();
        List<MatchResult> matchResults = findAllByGroup(group);
        for (MatchResult matchResult : matchResults) {
            nations.addAll(matchResult.getNations());
        }
        return new ArrayList<>(nations);
    }

    public static ScoreByNation findScoreByNation(Nation nation) {
        ScoreByNation scoreByNation = new ScoreByNation(nation);
        List<MatchResult> matchResults = findAllByNation(nation);
        for (MatchResult matchResult : matchResults) {
            countGameResult(nation, scoreByNation, matchResult);
        }
        scoreByNation.addGoalDifference(countGoalDifference(nation));
        scoreByNation.addPoints(countPoints(nation));
        scoreByNation.addGoalCount(countGoal(nation));
        return scoreByNation;
    }

    private static int countGoal(Nation nation) {
        List<MatchResult> matchResults = findAllByNation(nation);
        int totalGoalCount = 0;
        for (MatchResult matchResult : matchResults) {
            totalGoalCount += matchResult.goalCount(nation);
        }
        return totalGoalCount;
    }

    private static int countPoints(Nation nation) {
        List<MatchResult> matchResults = findAllByNation(nation);
        int totalPoint = 0;
        for (MatchResult matchResult : matchResults) {
            totalPoint = getPoint(nation, totalPoint, matchResult);
        }
        return totalPoint;
    }

    private static int getPoint(Nation nation, int point, MatchResult matchResult) {
        GameResult gameResult = matchResult.getGameResultOf(nation);
        if (gameResult == GameResult.WIN) {
            point += 3;
        }
        if (gameResult == GameResult.TIE) {
            point += 1;
        }
        return point;
    }

    private static int countGoalDifference(Nation nation) {
        List<MatchResult> matchResults = findAllByNation(nation);

        int goalDifference = 0;
        for (MatchResult matchResult : matchResults) {
            goalDifference += matchResult.getGoalDifference(nation);
        }
        return goalDifference;
    }

    private static void countGameResult(Nation nation, ScoreByNation scoreByNation, MatchResult matchResult) {
        if (matchResult.getGameResultOf(nation) == GameResult.WIN) {
            scoreByNation.addWinningCount();
        }
        if (matchResult.getGameResultOf(nation) == GameResult.LOSE) {
            scoreByNation.addLostCount();
        }
        if (matchResult.getGameResultOf(nation) == GameResult.TIE) {
            scoreByNation.addTieCount();
        }
    }

    public static List<MatchResult> findAllByNation(Nation nation) {
        return matchResults
                .stream().filter(matchResult -> matchResult.hasNation(nation))
                .collect(Collectors.toList());
    }

    public static Group findGroupByNation(Nation nation) {
        return matchResults.stream()
                .filter(matchResult -> matchResult.hasNation(nation))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getGroup();
    }
}
