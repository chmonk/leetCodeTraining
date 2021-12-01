package search_sort;

public class BinarySearch704 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int search(int[] nums, int target) {
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

		// 檢測 nums.length==1 與 夾擠到剩頭尾兩數時
		if (nums[start_idx] == target) {
			return start_idx;
		} else if (nums[end_idx] == target) {
			return end_idx;
		}

		return -1;
	}

}
