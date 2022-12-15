package worldcup.service;

import worldcup.dto.ScoreByNation;
import worldcup.dto.ScoreByNationAndMatchResult;
import worldcup.group.Group;
import worldcup.match.MatchRepository;
import worldcup.match.MatchResult;
import worldcup.nation.Nation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MatchService {

    public static final String RANK_NOT_FOUNT_EXCEPTION = "등수를 찾을 수 없음";

    public static List<MatchResult> findAllByGroup(Group group) {
        return MatchRepository.findAllByGroup(group);
    }

    public static List<ScoreByNation> findScoresByGroup(Group group) {
        List<ScoreByNation> matchResults = new ArrayList<>();
        List<Nation> nations = MatchRepository.findAllNationsByGroup(group);
        for (Nation nation : nations) {
            matchResults.add(MatchRepository.findScoreByNation(nation));
        }
        sortMatchResults(matchResults);
        return matchResults;
    }

    public static ScoreByNationAndMatchResult findScoreByNation(Nation nation) {
        ScoreByNation score = MatchRepository.findScoreByNation(nation);
        List<MatchResult> matchResults = MatchRepository.findAllByNation(nation);
        Group group = getGroupByNation(nation);
        int rank = getRank(group, nation);

        return new ScoreByNationAndMatchResult(score, matchResults, group, rank);
    }

    private static int getRank(Group group, Nation nation) {
        List<ScoreByNation> scores = findScoresByGroup(group);
        for (int rank = 0; rank < scores.size(); rank++) {
            if (scores.get(rank).isNation(nation)) {
                return rank + 1;
            }
        }
        throw new IllegalStateException(RANK_NOT_FOUNT_EXCEPTION);
    }

    private static Group getGroupByNation(Nation nation) {
        return MatchRepository.findGroupByNation(nation);
    }

    private static void sortMatchResults(List<ScoreByNation> matchResults) {
        matchResults
                .sort(Comparator
                        .comparing(ScoreByNation::getPoint).reversed()
                        .thenComparing(ScoreByNation::getGoalDifference).reversed()
                        .thenComparing(ScoreByNation::getGoalCount).reversed());
    }
}
