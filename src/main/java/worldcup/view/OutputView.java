package worldcup.view;

import java.util.Arrays;
import worldcup.view.constant.Command;
import worldcup.view.constant.OutputFormat;
import worldcup.view.constant.OutputMessage;

public class OutputView {
    public void printMain() {
        System.out.println(OutputMessage.INFORM_START);
        System.out.println();
        Arrays.stream(Command.values())
                .forEach(command -> System.out.printf(OutputFormat.MAIN_COMMAND, command.getKey(), command.getValue()));
    }
}
