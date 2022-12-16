package worldcup.view.constant;

public enum Command {
    ALL("1", "경기 결과 출력"),
    GROUP("2", "조별 결과 출력"),
    TEAM("3", "국가 경기 및 순위 결과 출력"),
    ADVANCE_TEAMS("4", "16강 진출 국가 출력"),
    QUIT("5", "종료");

    private final String key;
    private final String value;

    Command(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
