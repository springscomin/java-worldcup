package worldcup.service;

import worldcup.group.Group;
import worldcup.match.MatchRepository;
import worldcup.match.MatchResult;
import worldcup.nation.Nation;
import worldcup.vo.ScoreByNation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MatchService {
    public static List<MatchResult> findAllByGroup(Group group) {
        return MatchRepository.findAllByGroup(group);
    }

    public static List<ScoreByNation> findScoresByGroup(Group group) {
        List<ScoreByNation> matchResults = new ArrayList<>();
        List<Nation> nations = MatchRepository.findAllNationsByGroup(group);
        for (Nation nation : nations) {
            matchResults.add(MatchRepository.findScoreOfNationByGroup(nation, group));
        }
        sortMatchResults(matchResults);
        return matchResults;
    }

    private static void sortMatchResults(List<ScoreByNation> matchResults) {
        matchResults
                .sort(Comparator
                        .comparing(ScoreByNation::getPoint).reversed()
                        .thenComparing(ScoreByNation::getGoalDifference).reversed()
                        .thenComparing(ScoreByNation::getGoalCount).reversed());
    }
}
