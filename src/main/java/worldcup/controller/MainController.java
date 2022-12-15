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
        if (command == MainCommand.MATCH_RESULT) {
            ControllerHolder.get(ControllerName.ALL_MATCH_RESULT).process();
        }
        if (command == MainCommand.GROUP_RESULT) {
            ControllerHolder.get(ControllerName.GROUP_MATCH_RESULT).process();
        }
    }
}
