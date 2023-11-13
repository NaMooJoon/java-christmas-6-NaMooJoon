package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Order;
import christmas.domain.constants.Menu;
import christmas.exception.InvalidDateException;
import christmas.exception.InvalidOrderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputView {
    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_DASH = "-";
    private static final int MENU_INDEX = 0;
    private static final int NUMBER_INDEX = 1;

    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();

        try {
            int date = Integer.parseInt(input);
            return date;
        } catch (NumberFormatException e) {
            throw new InvalidDateException();
        }
    }

    public List<Order> readOrders() {
        System.out.println("주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();

        List<Order> orders = new ArrayList<>();
        try {
            for (String token : input.split(DELIMITER_COMMA)) {
                String[] data = token.split(DELIMITER_DASH);
                Order order = Order.nameAndCountOf(data[MENU_INDEX], Integer.parseInt(data[NUMBER_INDEX]));
                orders.add(order);
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new InvalidOrderException();
        }

        return orders;
    }
}
