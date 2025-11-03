package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다.");
        }
        return money;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] parts = Console.readLine().split(",");
        List<Integer> numbers = Arrays.stream(parts)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        return numbers;
    }

    public static int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
