package cycle01_search_and_sort;

public class BinarySearch_704 {
	public int search(int[] nums, int target) {

		// ����Q���i�H�]�w���while�Y�i�ѨM, �S�`�N��g�L�C������1/2��̲׷|�J��u�b���index���˴������p,�n�h�`�Nwhile�����ĵ��G
		// binary search, select right or left part

		int start_idx = 0;
		int end_idx = nums.length - 1;
		int test_idx = end_idx;

		while (start_idx < end_idx && end_idx - start_idx > 1) {

			test_idx = (end_idx + start_idx) / 2;

			if (nums[test_idx] > target) {
				// watch fore part
				end_idx = test_idx;
			} else if (nums[test_idx] < target) {
				// watch post part
				start_idx = test_idx;
			} else {
				return test_idx;
			}
		}

		// �˴� nums.length==1 �P ��������Y����Ʈ�
		if (nums[start_idx] == target) {
			return start_idx;
		} else if (nums[end_idx] == target) {
			return end_idx;
		}

		return -1;
	}
}
