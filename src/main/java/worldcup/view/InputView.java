package worldcup.view;

import camp.nextstep.edu.missionutils.Console;
import worldcup.controller.MenuCommand;

public class InputView {
    public static final String INPUT_MENU_COMMAND = "출력할 내용을 입력하세요. (1 ~ 5)";
    public static final String INPUT_GROUP_NAME = "출력할 조를 입력하세요 (A ~ H)";

    public MenuCommand inputMenuCommand() {
        System.out.println();
        System.out.println(INPUT_MENU_COMMAND);
        return MenuCommand.findByKey(Console.readLine());
    }

    public String inputGroupName() {
        System.out.println();
        System.out.println(INPUT_GROUP_NAME);
        return Console.readLine();
    }
}
