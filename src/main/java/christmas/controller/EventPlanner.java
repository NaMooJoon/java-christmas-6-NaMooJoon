package christmas.controller;

import christmas.domain.Date;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlanner {
    InputView inputView;
    OutputView outputView;

    public EventPlanner() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        greetingMessage();
        Date date = createDate();

    }

    private void greetingMessage() {
        outputView.printStartingMessage();
    }

    private Date createDate() {
        while (true) {
            try {
                int date = inputView.readDate();
                return Date.of(date);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
