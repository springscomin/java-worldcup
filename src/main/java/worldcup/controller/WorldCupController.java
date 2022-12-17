package worldcup.controller;

import java.util.List;
import java.util.Map;
import worldcup.controller.util.ExceptionHandler;
import worldcup.model.WorldCupService;
import worldcup.model.domain.Match;
import worldcup.model.domain.TeamResult;
import worldcup.view.InputView;
import worldcup.view.OutputView;

public class WorldCupController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final WorldCupService worldCupService = new WorldCupService();

    public void run() {
        outputView.printMain();
        MenuCommand command = ExceptionHandler.retryForIllegalArgument(inputView::inputMenuCommand,
                outputView::printErrorMessage);
        if (command == MenuCommand.QUIT) {
            return;
        }
        executeMenu(command);
        run();
    }

    private void executeMenu(MenuCommand command) {
        if (command == MenuCommand.ALL) {
            showAllMatches();
        }
        if (command == MenuCommand.GROUP) {
            ExceptionHandler.retryForIllegalArgument(this::showGroupMatches, outputView::printErrorMessage);
        }
        if (command == MenuCommand.TEAM) {
            ExceptionHandler.retryForIllegalArgument(this::showTeamMatchResults, outputView::printErrorMessage);
        }
        if (command == MenuCommand.ADVANCE_TEAMS) {
            showAdvancedTeams();
        }
    }

    public void showAllMatches() {
        Map<String, List<Match>> allMatches = worldCupService.getAllMatchesByGroup();
        outputView.printAllMatchesByGroup(allMatches);
    }

    public void showGroupMatches() {
        String groupName = inputView.inputGroupName();
        List<TeamResult> results = worldCupService.getTeamResultsByGroup(groupName);
        outputView.printTeamResultsByGroup(groupName, results);
    }

    public void showTeamMatchResults() {
        String teamName = inputView.inputTeamName();
        TeamResult teamResult = worldCupService.getTeamResultByName(teamName);
        List<Match> matches = worldCupService.getTeamMatchesByName(teamName);
        outputView.printTeamMatchResults(teamResult, matches);
    }

    public void showAdvancedTeams() {
        Map<String, List<String>> advancedTeamsByGroup = worldCupService.getAdvancedTeamsByGroup();
        outputView.printAdvancedTeams(advancedTeamsByGroup);
    }
}
