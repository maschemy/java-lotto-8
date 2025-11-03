package lotto;

import java.util.*;

public class OutputView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printResult(LottoResult result, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> map = result.getResultMap();

        System.out.println("3개 일치 (5,000원) - " + map.getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + map.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + map.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + map.getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + map.getOrDefault(Rank.FIRST, 0) + "개");

        double rate = result.calculateProfitRate(purchaseAmount);
        double roundedRate = Math.round(rate * 10) / 10.0; // 소수점 둘째 자리 반올림
        System.out.printf("총 수익률은 %.1f%%입니다.%n", roundedRate); // ✅ 테스트 통과 출력
    }
}
