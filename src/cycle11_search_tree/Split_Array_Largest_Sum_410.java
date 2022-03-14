package cycle11_search_tree;

public class Split_Array_Largest_Sum_410 {

	public int splitArray(int[] nums, int m) {

		// boundary btw 1. the max in nums and 2. sum of nums
		int left = 0;
		int right = 0;

		for (int num : nums) {
			left = Math.max(left, num);
			right += num;
		}

		while (left < right) {

			int med = left + (right - left) / 2;

			int count = 1;  // not start from 0

			int sum = 0;

			loop: for (int num : nums) {
				sum += num;
				if (sum > med) {
					count++;
					sum = num;
				}

				if (count > m) {
					break loop;
				}
			}

			if (count > m) {
				left = med + 1;
			} else {
				
				right = med;
			}

		}

		return left;

	}

}
