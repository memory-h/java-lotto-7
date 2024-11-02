package lotto.constants;

public enum ViewMessage {

    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    LOTTO_PURCHASE_COUNT("\n%d개를 구매했습니다.");

    private final String text;

    ViewMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}