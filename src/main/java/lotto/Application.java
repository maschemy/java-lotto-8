package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            int money = InputView.inputMoney();
            int count = money / 1000;
            List<Lotto> lottos = LottoMachine.generate(count);

            System.out.println(count + "개를 구매했습니다.");
            for (Lotto lotto : lottos) {
                System.out.println(lotto);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
