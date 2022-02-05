package cycle01_search_and_sort;

public class ArrayPartitionI_561 {
//	相近兩數為一組,犧牲的差值愈少=> 排序陣列後取偶數index(0,2,4....)總合為所求

	public int arrayPairSum(int[] nums) {

		// sorting and pairing
		sort(nums, 0, nums.length - 1);
		// pick index 0 2 4 ...... == res
		int res = 0;
		int idx = 0;
		while (idx < nums.length) {
			res += nums[idx];
			idx += 2;
		}
		return res;
	}

	private void sort(int[] test, int i, int j) {
		// quick sort
		if (i < j) {
			int pivot = partition(test, i, j);
			sort(test, i, pivot - 1);
			sort(test, pivot + 1, j);
		}

	}

	private int partition(int[] nums, int start_idx, int end_idx) {

		int pivot_idx = end_idx;
		int lower_idx = start_idx;

		for (int i = start_idx; i < end_idx; i++) {
			if (nums[pivot_idx] > nums[i]) {
				swap(nums, i, lower_idx);
				lower_idx++;
			}
		}

		swap(nums, lower_idx, pivot_idx);

		return lower_idx;
	}

	private void swap(int[] nums, int a, int b) {
		int memory = nums[a];
		nums[a] = nums[b];
		nums[b] = memory;
	}
}
