package worldcup.controller;

import worldcup.dto.ScoreByNationAndMatchResult;
import worldcup.inputview.MatchResultInputView;
import worldcup.nation.Nation;
import worldcup.nation.NationRepository;
import worldcup.outputview.MatchResultOutputView;
import worldcup.service.MatchService;

public class MatchResultByNationController extends AbstractController {
    @Override
    void doProcess() {
        Nation nation = getNation();
        ScoreByNationAndMatchResult score = MatchService.findScoreByNation(nation);
        MatchResultOutputView.printMatchResultByNation(nation, score);
    }

    private static Nation getNation() {
        MatchResultOutputView.printAskingNationName();
        String nationName = MatchResultInputView.getNationName();
        return NationRepository.findByName(nationName);
    }
}
