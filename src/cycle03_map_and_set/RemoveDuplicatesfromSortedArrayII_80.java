package cycle03_map_and_set;

public class RemoveDuplicatesfromSortedArrayII_80 {

	// 設置current 當前nums[i]!=current, then current=nums[i] , counter=0
	// 同時nums[new_array_idx++]=nums[i];
	// 當 當前nums[i]==current, counter=0 =>nums[new_array_idx++]=nums[i] ,counter++
	// 當 當前nums[i]==current, counter!=0 =>counter++
	public int removeDuplicates(int[] nums) {
		int new_array_idx = 1;

		int current = nums[0];

		int counter = 0; // take nums[0] into consideration

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] != current) {
				nums[new_array_idx++] = nums[i];
				current = nums[i];
				counter = 0;
			} else if (nums[i] == current && counter == 0) {
				nums[new_array_idx++] = nums[i];
				counter++;
			} else {
				counter++;
			}
		}

		return new_array_idx;
	}
}
