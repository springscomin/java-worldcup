package worldcup.controller;

import worldcup.inputview.MainInputView;
import worldcup.outputview.MainOutputView;
import worldcup.vo.command.MainCommand;

public class MainController extends AbstractController {
    @Override
    void doProcess() {
        MainOutputView.printFeatures();
        MainCommand command = MainInputView.getCommand();
    }
}
