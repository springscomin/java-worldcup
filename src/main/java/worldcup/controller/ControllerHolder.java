package worldcup.controller;

import worldcup.vo.ControllerName;

import java.util.HashMap;
import java.util.Map;

public class ControllerHolder {
    private static final Map<ControllerName, Controller> controllers = new HashMap<>();

    static {
        controllers.put(ControllerName.SETUP, new SetupController());
        controllers.put(ControllerName.MAIN, new MainController());
        controllers.put(ControllerName.ALL_MATCH_RESULT, new AllMatchResultController());
    }
    public static Controller get(ControllerName controllerName) {
        return controllers.get(controllerName);
    }
}
