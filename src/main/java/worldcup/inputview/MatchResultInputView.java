package worldcup.inputview;

public class MatchResultInputView extends AbstractInputView {

    public static final String GROUP_NAME_FORMAT = "%s조";

    public static String getGroupName() {
        return String.format(GROUP_NAME_FORMAT, readInput());
    }

    public static String getNationName() {
        return readInput();
    }
}
