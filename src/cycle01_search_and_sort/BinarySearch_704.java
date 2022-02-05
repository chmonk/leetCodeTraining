package cycle01_search_and_sort;

public class BinarySearch_704 {
	public int search(int[] nums, int target) {

		// 原先想說可以設定單個while即可解決, 沒注意到經過每次切割1/2後最終會遇到只在兩個index間檢測的情況,要多注意while的收斂結果
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
