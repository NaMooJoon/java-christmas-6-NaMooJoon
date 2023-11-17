package christmas.controller;

import christmas.domain.Date;
import christmas.domain.EventCalculator;
import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class EventController {
    private InputView inputView;
    private OutputView outputView;

    public EventController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        greetingMessage();
        Date date = createDate();
        Orders orders = createOrder();

        previewStartingMessage(date);
        EventCalculator eventCalculator = EventCalculator.of(date, orders);

        ordersSummaryMessage(orders);
        benefitSummaryMessage(eventCalculator);

        badgeMessage(eventCalculator);
    }

    private void greetingMessage() {
        outputView.printStartingMessage();
    }

    private Date createDate() {
        while (true) {
            try {
                int date = inputView.readDate();
                return Date.from(date);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Orders createOrder() {
        while (true) {
            try {
                List<Order> orders = inputView.readOrders();
                return Orders.from(orders);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void previewStartingMessage(Date date) {
        outputView.printStartingPreviewMessage(date);
    }

    private void ordersSummaryMessage(Orders orders) {
        outputView.printListMessageOf(orders);
        outputView.printTotalAmountOf(orders);
    }

    private void benefitSummaryMessage(EventCalculator eventCalculator) {
        outputView.printEventGiftsMessage(eventCalculator.getEventGift());
        outputView.printBenefitsListMessage(eventCalculator.getAllBenefits());
        outputView.printTotalAmountOf(eventCalculator.getAllBenefits());
        outputView.printExpectedAmountAfterDiscount(eventCalculator.getExpectedAmountToPay());
    }

    private void badgeMessage(EventCalculator eventCalculator) {
        outputView.printBadgeMessage(eventCalculator.getBadge());
    }

}
