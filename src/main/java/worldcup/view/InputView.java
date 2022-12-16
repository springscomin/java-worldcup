package worldcup.view;

import camp.nextstep.edu.missionutils.Console;
import worldcup.controller.MenuCommand;
import worldcup.view.constant.InputMessage;

public class InputView {
    public MenuCommand inputMenuCommand() {
        System.out.println();
        System.out.println(InputMessage.INPUT_MENU_COMMAND);
        String line = Console.readLine();
        System.out.println();
        return MenuCommand.findByKey(line);
    }
}
