package cycle03_map_and_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleNumber_136 {
	public int singleNumber(int[] nums) {
		Set<Integer> ans = new HashSet<Integer>();

		for (int val : nums) {
			if (ans.contains(val)) {
				ans.remove(val);
			} else {
				ans.add(val);
			}
		}
		return ans.iterator().next();
	}}

//	sort and
//	then check
//	°£¤F idx = 0
//	and length-1(last)¥~,when num[n-1]!=nums[n]

	// && nums[n]!=nums[n+1] return n
	class Solution2 {
		public int singleNumber(int[] nums) {
			if (nums.length == 1) {
				return nums[0];
			} else {

				Arrays.sort(nums);

				if (nums[0] != nums[1]) {
					return nums[0];
				} else if (nums[nums.length - 2] != nums[nums.length - 1]) {
					return nums[nums.length - 1];
				}

				int idx = 1;

				while (idx < nums.length - 1) {
					if (nums[idx] != nums[idx - 1] && nums[idx] != nums[idx + 1]) {
						return nums[idx];
					}
					idx++;
				}
			}
			return Integer.MIN_VALUE;
		}
	
}
