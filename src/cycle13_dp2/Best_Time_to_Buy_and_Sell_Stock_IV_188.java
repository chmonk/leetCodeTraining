package cycle13_dp2;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_IV_188 {

	// iv解不出 從i開始解 2h

//拆成簡單概念  第i次的交易成本 與第i次的獲益
	public int maxProfit(int k, int[] prices) {

		if (prices.length == 0 || k == 0) {
			return 0;
		}

		int[] cost = new int[k];
		Arrays.fill(cost, Integer.MAX_VALUE);

		int[] profit = new int[k];
		Arrays.fill(profit, Integer.MIN_VALUE);

		for (int price : prices) {

			cost[0] = Math.min(cost[0], price);
			profit[0] = Math.max(profit[0], price - cost[0]);

			for (int i = 1; i < k; i++) {
				cost[i] = Math.min(cost[i], price - profit[i - 1]);
				profit[i] = Math.max(profit[i], price - cost[i]);
			}
		}

		return profit[k - 1];
	}
}
