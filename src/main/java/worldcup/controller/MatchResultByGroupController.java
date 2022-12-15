package worldcup.controller;

import worldcup.group.Group;
import worldcup.group.GroupRepository;
import worldcup.inputview.MatchResultInputView;
import worldcup.outputview.MatchResultOutputView;
import worldcup.service.MatchService;
import worldcup.dto.ScoreByNation;

import java.util.List;

public class MatchResultByGroupController extends AbstractController {
    @Override
    void doProcess() {
        MatchResultOutputView.printAskingGroupName();
        Group group = getGroup();
        List<ScoreByNation> scores = MatchService.findScoresByGroup(group);
        MatchResultOutputView.printMatchResultsByGroup(group, scores);
    }

    private static Group getGroup() {
        String groupName = MatchResultInputView.getGroupName();
        return GroupRepository.findByName(groupName);
    }
}
