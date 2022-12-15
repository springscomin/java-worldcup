package worldcup.outputview;

public enum CommonConstant {
    LINE_SEPARATOR("============================================================");

    private final String text;

    CommonConstant(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
