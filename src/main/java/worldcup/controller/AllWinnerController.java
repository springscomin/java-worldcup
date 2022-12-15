package worldcup.controller;

import worldcup.dto.ScoreByNation;
import worldcup.group.Group;
import worldcup.group.GroupRepository;
import worldcup.outputview.MatchResultOutputView;
import worldcup.service.MatchService;

import java.util.*;

public class AllWinnerController extends AbstractController {
    @Override
    void doProcess() {
        Map<String, List<String>> winnerNationNames = new TreeMap<>();
        for (Group group : GroupRepository.findAll()) {
            addGroupNameAndWinners(winnerNationNames, group);
        }
        MatchResultOutputView.printAllWinnersByGroup(winnerNationNames);
    }

    private static void addGroupNameAndWinners(Map<String, List<String>> winnerNationNames, Group group) {
        List<ScoreByNation> scores = MatchService.findScoresByGroup(group);
        winnerNationNames.put(group.getName(),
                List.of(
                        scores.get(0).getNationName(),
                        scores.get(1).getNationName()
                ));
    }
}
