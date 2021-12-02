package sort;

public class quickSort {

	public void quickSort(int[] nums, int start_idx, int end_idx) {

		// termination condition
		if (end_idx - start_idx < 1) {
			return;
		}

		//use the last idx as pivot 
		int pivot = nums[end_idx];

		int lower_idx = start_idx;

		for (int loop_idx = start_idx; loop_idx < end_idx; loop_idx++) {
			//while the number smaller than pivot,replace this num to the lower_idx
			if (nums[loop_idx] < pivot) {
				swap(nums, lower_idx, loop_idx);
				lower_idx++;
			}
		}

		swap(nums, lower_idx, end_idx);

		// number array idx lower than lower_idx are smaller than the pivot 
		quickSort(nums, start_idx, lower_idx - 1);

		// number array idx larger than lower_idx are larger than the pivot 
		quickSort(nums, lower_idx + 1, end_idx);

	}

	private void swap(int[] nums, int a, int b) {
		int record = nums[a];
		nums[a] = nums[b];
		nums[b] = record;
	}
}
