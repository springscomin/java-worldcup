package worldcup.vo.command;

import java.util.Arrays;

public enum MainCommand {
    MATCH_RESULT("1", "경기 결과 출력"),
    GROUP_RESULT("2", "조별 결과 출력"),
    NATION_RESULT("3", "국가 경기 및 순위 결과 출력"),
    WINNER_RESULT("4", "16강 진출 국가 출력"),
    QUIT("5", "종료");

    public static final String INVALID_COMMAND_VALUE = "잘못된 커맨드 입력";
    private final String command;
    private final String description;

    MainCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static MainCommand getByCommand(String command) {
        return Arrays.stream(values())
                .filter(mainCommand -> mainCommand.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_VALUE));
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}
