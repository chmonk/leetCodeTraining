package cycle13_dp2;

import java.util.HashSet;
import java.util.Set;

//注意可以累積的  dp 
public class Maximum_Number_of_Non_Overlapping_Subarrays_With_Sum_Equals_Target_1546 {
	public int maxNonOverlapping(int[] nums, int target) {
		int count = 0;

		int cur_total = 0;

		Set<Integer> collect = new HashSet<>();

		for (int num : nums) {

			cur_total += num;

			if (cur_total == target || collect.contains(cur_total - target)) {
				collect.clear();
				count++;
				cur_total = 0;
			} else {
				collect.add(cur_total);
			}

		}

		return count;
	}
}
