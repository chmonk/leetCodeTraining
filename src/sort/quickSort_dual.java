package sort;

public class quickSort_dual {

	public void quickSort_dual(int[] nums, int start_idx, int end_idx) {

		// termination condition
		if (start_idx >= end_idx) {
			return;
		}

		int middle_idx = start_idx + (end_idx - start_idx) / 2; //avoid big number

		int pivot_idx = end_idx;

		//use the middle value as pivot to separate the array 
		if (nums[start_idx] > nums[middle_idx]) {
			swap(nums, start_idx, middle_idx);
		}
		if (nums[end_idx] < nums[middle_idx]) {
			swap(nums, end_idx, middle_idx); 
		}
		if (nums[start_idx] > nums[middle_idx]) {
			swap(nums, start_idx, middle_idx);
		}
		swap(nums, end_idx, middle_idx);

		int low = start_idx;
		int high = end_idx - 1; // leave pivot as standard
		
		int loop_idx = start_idx;

		while (loop_idx <= high) {

			if (nums[loop_idx] < nums[pivot_idx]) {
				// < pivot , exchange with the nums[++low] (exchange with the number bigger than
				// pivot),loop++
				swap(nums, low++, loop_idx++);
			} else if (nums[loop_idx] == nums[pivot_idx]) {
				// == pivot , loop++
				loop_idx++;
			} else {
				// >pivot exchange with the nums[high] and loop_idx don't ++ for check the
				swap(nums, high--, loop_idx);
			}
		}

		swap(nums, ++high, pivot_idx); // put the pivot value in the middle 

		quickSort_dual(nums, start_idx, --low); //owing to low++, in the end, now the low idx is the pivot value, so --low 

		quickSort_dual(nums, ++high, end_idx); // in the end, high idx is the pivot, ++high lead to high point to the number larger than pivot

	}

	private void swap(int[] nums, int lower_idx, int loop_idx) {
		int record = nums[lower_idx];
		nums[lower_idx] = nums[loop_idx];
		nums[loop_idx] = record;
	}

}
