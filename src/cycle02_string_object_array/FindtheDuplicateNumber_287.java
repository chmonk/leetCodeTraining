package cycle02_string_object_array;

public class FindtheDuplicateNumber_287 {

	// �]���Ȥ@���ƼƦr
//	�N�����Ȫ�num[value]�i�楿�t��½��,½��ᬰ���ƪ���ܤw�Q����L=>���ƼƦr
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
