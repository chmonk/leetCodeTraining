package search_sort;

public class BinarySearch704 {

	public int search(int[] nums, int target) {
		
		int len = nums.length;

		int start = 0;
		int end = len - 1;

		while (start <= end) {
			int med = start + (end - start) / 2;

			if (start == end && nums[med] != target) {
				break;
			}

			if (nums[med] > target) {
				end = med;
			} else if (nums[med] < target) {
				start = med + 1;
			} else {
				return med;
			}
		}

		return -1;

	}

}
