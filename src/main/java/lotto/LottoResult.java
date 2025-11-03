package lotto;

import java.util.*;

public class LottoResult {
    private final Map<Rank, Integer> resultMap = new EnumMap<>(Rank.class);

    public LottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatches(winningNumbers);
            boolean hasBonus = lotto.contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, hasBonus);
            resultMap.put(rank, resultMap.getOrDefault(rank, 0) + 1);
        }
    }

    public Map<Rank, Integer> getResultMap() {
        return Collections.unmodifiableMap(resultMap);
    }

    public long getTotalPrize() {
        return resultMap.entrySet().stream()
                .mapToLong(e -> (long) e.getKey().getPrize() * e.getValue())
                .sum();
    }

    public double getProfitRate(int purchaseAmount) {
        return ((double) getTotalPrize() / purchaseAmount) * 100;
    }
}
