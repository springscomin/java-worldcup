package worldcup.outputview;

import worldcup.vo.command.MainCommand;

public class MainOutputView {

    public static final String FEATURES_FORMAT = "%s. %s%n";
    public static final String MAIN_MESSAGE = "카타르 월드컵 조별리그 결과";
    public static final String ASKING_COMMAND_MESSAGE = "출력할 내용을 입력하세요. (1 ~ 5)";

    public static void printFeatures() {
        System.out.println();

        System.out.println(MAIN_MESSAGE);
        System.out.println();

        printCommands();

        System.out.println();
        System.out.println(ASKING_COMMAND_MESSAGE);
    }

    private static void printCommands() {
        for (MainCommand mainCommand : MainCommand.values()) {
            System.out.printf(FEATURES_FORMAT, mainCommand.getCommand(), mainCommand.getDescription());
        }
    }
}
