package christmas.view;

import christmas.domain.Date;
import christmas.domain.Benefits;
import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.domain.constants.Badge;
import java.util.Locale;

public class OutputView {

    public void printStartingMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printStartingPreviewMessage(Date date) {
        System.out.println(date.toString() +"에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public void printListMessageOf(Orders orders) {
        System.out.println("<주문 메뉴>");
        System.out.println(orders.toString());
        System.out.println();
    }

    public void printTotalAmountOf(Orders orders) {
        int total = orders.getTotalAmount();
        String formattedAmount = String.format(Locale.KOREA, "%,d원", total);

        System.out.println("<할인 전 총주문 금액>");
        System.out.println(formattedAmount);
        System.out.println();
    }

    public void printTotalAmountOf(Benefits benefits) {
        System.out.println("<총혜택 금액>");
        if (benefits.isEmpty()) {
            System.out.println("0원");
            System.out.println();
            return;
        }

        int total = benefits.getTotalAmount();
        String formattedAmount = String.format(Locale.KOREA, "-%,d원", total);

        System.out.println(formattedAmount);
        System.out.println();
    }

    public void printEventGiftsMessage(Order gift) {
        System.out.println("<증정 메뉴>");
        if (gift == null) {
            System.out.println("없음\n");
            return;
        }
        System.out.println(gift.toString());
        System.out.println();
    }

    public void printBenefitsListMessage(Benefits benefits) {
        System.out.println("<혜택 내역>");

        System.out.println(benefits.toString());
        System.out.println();
    }

    public void printExpectedAmountAfterDiscount(int amount) {
        String formattedAmount = String.format(Locale.KOREA, "%,d원", amount);
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(formattedAmount);
        System.out.println();
    }

    public void printBadgeMessage(Badge badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge.getName());
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

}
