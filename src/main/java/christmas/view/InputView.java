package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.exception.InvalidDateException;

public class InputView {

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
}
