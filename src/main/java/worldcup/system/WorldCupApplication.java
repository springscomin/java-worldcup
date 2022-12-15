package worldcup.system;

import worldcup.controller.ControllerHolder;
import worldcup.vo.ControllerName;

public class WorldCupApplication {
    public void run() {
        doSetup();
        ControllerHolder.get(ControllerName.MAIN).process();
    }

    private static void doSetup() {
        ControllerHolder.get(ControllerName.SETUP).process();
    }
}
