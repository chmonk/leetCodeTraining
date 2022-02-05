package cycle12_dp;

public class CoinChange2_518 {

	/*
	 * �ѩ�u�Ҽ{�Ʋ�tuple: �����O���ƦCf[n]=f[n-1]+f[n-2]
	 * 
	 * �Ҽ{�� ��ίS�w�@�ع��ȲեX�j�p���`�M��array�O�� ���|�[
	 * 
	 * �|�[���󬰦Pamount�U �ӹ��Ȼݤp��amount
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
