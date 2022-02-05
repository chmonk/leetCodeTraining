package cycle02_string_object_array;

public class FindtheDuplicateNumber_287 {

	// 因為僅一重複數字
//	將對應值的num[value]進行正負號翻轉,翻轉後為正數的表示已被反轉過=>重複數字
	public int findDuplicate(int[] nums) {
		for (int num : nums) {

			int r = Math.abs(num);

			nums[r] = -1 * nums[r];
			if (nums[r] > 0) {
				return r;
			}
		}

		return 1;
	}
}
