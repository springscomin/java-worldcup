package worldcup.controller;

import worldcup.model.WorldCupService;
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

    }

    private void showGroupMatches() {

    }

    private void showTeamMatchResults() {

    }

    private void showAdvancedTeams() {

    }
}
