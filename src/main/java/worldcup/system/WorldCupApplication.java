package worldcup.system;

import worldcup.controller.ControllerHolder;
import worldcup.vo.ControllerName;

public class WorldCupApplication {
    public void run() {
        ControllerHolder.get(ControllerName.SETUP).process();
    }
}
