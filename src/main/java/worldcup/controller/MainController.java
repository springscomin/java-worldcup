package worldcup.controller;

import worldcup.inputview.MainInputView;
import worldcup.outputview.MainOutputView;
import worldcup.vo.ControllerName;
import worldcup.vo.command.MainCommand;

public class MainController extends AbstractController {
    @Override
    void doProcess() {
        MainOutputView.printFeatures();
        MainCommand command = MainInputView.getCommand();
        doFindingAllMatchResultProcess(command);
        doFindingMatchResultByGroupProcess(command);
        doFindMatchResultByNationProcess(command);
        if (command == MainCommand.WINNER_RESULT) {
            ControllerHolder.get(ControllerName.WINNER_RESULT).process();
        }
    }

    private static void doFindMatchResultByNationProcess(MainCommand command) {
        if (command == MainCommand.NATION_RESULT) {
            ControllerHolder.get(ControllerName.NATION_MATCH_RESULT).process();
        }
    }

    private static void doFindingMatchResultByGroupProcess(MainCommand command) {
        if (command == MainCommand.GROUP_RESULT) {
            ControllerHolder.get(ControllerName.GROUP_MATCH_RESULT).process();
        }
    }

    private static void doFindingAllMatchResultProcess(MainCommand command) {
        if (command == MainCommand.MATCH_RESULT) {
            ControllerHolder.get(ControllerName.ALL_MATCH_RESULT).process();
        }
    }
}
