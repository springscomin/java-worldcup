package worldcup.controller;

import worldcup.group.Group;
import worldcup.group.GroupRepository;
import worldcup.match.MatchResult;
import worldcup.outputview.MatchResultOutputView;
import worldcup.service.MatchService;

import java.util.List;

public class AllMatchResultController extends AbstractController {
    @Override
    void doProcess() {
        for (Group group : GroupRepository.findAll()) {
            List<MatchResult> matchResults = MatchService.findAllByGroup(group);
            MatchResultOutputView.printAllMatchResultByGroup(group, matchResults);
        }
    }
}
