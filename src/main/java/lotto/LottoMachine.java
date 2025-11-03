package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
    public static List<Lotto> generate(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
