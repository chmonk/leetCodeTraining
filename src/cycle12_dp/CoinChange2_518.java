package cycle12_dp;

public class CoinChange2_518 {

	/*
	 * 由於只考慮數組tuple: 不像費式數列f[n]=f[n-1]+f[n-2]
	 * 
	 * 考慮成 單用特定一種幣值組出大小為總和的array記憶 後疊加
	 * 
	 * 疊加條件為同amount下 該幣值需小於amount
	 * 
	 */

	public int change(int amount, int[] coins) {
		int[] arr = new int[amount + 1];

		arr[0] = 1;

		for (int coin : coins) {
			for (int j = coin; j <= amount; j++) {
				arr[j] += arr[j - coin];
			}
		}

		return arr[amount];

	}
}
