package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            int money = InputView.inputMoney();
            int count = money / 1000;

            List<Lotto> lottos = LottoMachine.generate(count);
            OutputView.printLottos(lottos);

            List<Integer> winningNumbers = InputView.inputWinningNumbers();
            int bonusNumber = InputView.inputBonusNumber();

            LottoResult result = new LottoResult(lottos, winningNumbers, bonusNumber);
            OutputView.printResult(result, money);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
