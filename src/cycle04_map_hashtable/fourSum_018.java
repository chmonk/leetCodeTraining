package cycle04_map_hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class fourSum_018 {

	public List<List<Integer>> fourSum(int[] nums, int target) {

		Arrays.sort(nums);

		return ksum(nums, target, 0, 4);
	}

	private List<List<Integer>> ksum(int[] nums, int target, int idx, int n) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (idx >= nums.length)
			return res;

		if (n > 2) {

			for (int i = idx; i < nums.length - n + 1; i++) {

				List<List<Integer>> temp = ksum(nums, target - nums[i], i + 1, n - 1);

				if (!temp.isEmpty()) {
					for (List<Integer> ans : temp) {
						ans.add(0, nums[i]);
					}
				}
				res.addAll(temp);

				while (nums[i] == nums[i + 1] && (i < nums.length - n + 1)) {
					i++;
				}
			}
		} else {

			// 2 pointer
			int start = idx;
			int last = nums.length - 1;

			while (start < last) {
				int sum = nums[start] + nums[last];
				if (sum == target) {
					// res.add((ArrayList<Integer>)Arrays.asList(nums[start++], nums[last--]));
					res.add(new ArrayList<>(Arrays.asList(nums[start++], nums[last--])));
					while (start < last && nums[start] == nums[start - 1]) {
						start++;
					}
					while (start < last && nums[last] == nums[last + 1]) {
						last--;
					}
				} else if (sum > target) {
					last--;
				} else {
					start++;
				}
			}

		}

		return res;
	}

}
