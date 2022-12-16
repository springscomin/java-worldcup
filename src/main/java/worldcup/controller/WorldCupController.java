package worldcup.controller;

import java.util.List;
import java.util.Map;
import worldcup.model.WorldCupService;
import worldcup.model.domain.Match;
import worldcup.view.InputView;
import worldcup.view.OutputView;

public class WorldCupController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final WorldCupService worldCupService = new WorldCupService();

    public void run() {
        // TODO 입력값 예외 발생 시 해당 기능 재실행
        outputView.printMain();
        MenuCommand command = inputView.inputMenuCommand();
        // TODO 이 컨트롤러를 frontController로 만들고 별도 컨트롤러 정의해서 명령어 핸들러 클래스 분리
        if (command == MenuCommand.QUIT) {
            return;
        }
        if (command == MenuCommand.ALL) {
            showAllMatches();
        }
        if (command == MenuCommand.GROUP) {
            showGroupMatches();
        }
        if (command == MenuCommand.TEAM) {
            showTeamMatchResults();
        }
        if (command == MenuCommand.ADVANCE_TEAMS) {
            showAdvancedTeams();
        }
        run();
    }

    private void showAllMatches() {
        Map<String, List<Match>> allMatches = worldCupService.getAllMatchesByGroup();
        outputView.printAllMatchesByGroup(allMatches);
    }

    private void showGroupMatches() {

    }

    private void showTeamMatchResults() {

    }

    private void showAdvancedTeams() {

    }
}
