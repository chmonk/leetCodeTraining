package cycle12_dp;

public class Maximum_Subarray_53 {

	// dp �C�Ӧ�m�����Ӿ�� �]�t�q�_�l�쥻������̤j�ƭ�
	public int maxSubArray(int[] nums) {
		int[] memo = new int[nums.length];

		memo[0] = nums[0];
		int max = memo[0];
		for (int i = 1; i < nums.length; i++) {
			memo[i] = Math.max(memo[i - 1] + nums[i], nums[i]);
			max = Math.max(memo[i], max);
		}

		return max;
	}
}
