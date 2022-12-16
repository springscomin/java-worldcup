package worldcup.controller;

import worldcup.model.WorldCupService;
import worldcup.view.InputView;
import worldcup.view.OutputView;

public class WorldCupController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final WorldCupService worldCupService = new WorldCupService();

    public void run() {
        outputView.printMain();
    }
}
