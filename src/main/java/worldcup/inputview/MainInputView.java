package worldcup.inputview;

import worldcup.vo.command.MainCommand;

public class MainInputView extends AbstractInputView {
    public static MainCommand getCommand() {
        return MainCommand.getByCommand(readInput());
    }
}
