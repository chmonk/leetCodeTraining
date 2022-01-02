package cycle08_recursion;

public class Partition_to_K_EqualSumSubsets698 {

	public boolean canPartitionKSubsets(int[] nums, int k) {

		// nums.length>=k
		if (nums.length < k)
			return false;
		// m= sum can be divide by k without decimal point
		// element in nums[] must small then m
		int sum = 0;
		int max = 0;
		for (int ele : nums) {
			max = Math.max(max, ele);
			sum += ele;
		}

		int mean = sum / k;
		if (sum % k != 0 || max > mean)
			return false;

		// split into k part => recursive check comparable subset and do subtract
		return helper(nums, new boolean[nums.length], k, 0, mean, 0);

	}

	private boolean helper(int[] nums, boolean[] visited, int k, int sum, int mean, int idx) {

		if (k == 0)
			return true;
		if (sum == mean) {  //idx could be nums.length this if should before the next if check
			return helper(nums, visited, k - 1, 0, mean, 0);
		}
		if (idx >= nums.length)
			return false;

		for (int i = idx; i < nums.length; i++) {
			int new_sum = sum + nums[i];

			if (!visited[i] && new_sum <= mean) {
				visited[i] = true;
				if (helper(nums, visited, k, new_sum, mean, i + 1)) {
					return true;
				}
				visited[i] = false;
			}

		}

		return false;
	}
}
