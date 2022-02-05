package cycle11_search_tree;

public class Search_in_Rotated_Sorted_Array_33 {

	/**
	 * 1.直覺解五分鐘 2.求log(N) +debug花了1h..... 二分法逐步縮減範圍的條件(下次的查詢條件是否包含當次中位數要想得夠清楚)
	 * 少跑幾次無用的迴圈提升不少記憶體使用效率
	 */

//	1.直覺解 O(N)
	public static int search(int[] nums, int target) {
		int idx = 0;
		for (int num : nums) {
			if (num == target) {
				return idx;
			}
			idx++;
		}
		return -1;
	}

//	2. 反摺點+ 二分法O(logN)
	public int search_1(int[] nums, int target) {

//	        陣列大小小於3無反摺點=>直接判斷
		if (nums.length < 3) {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == target)
					return i;
			}
			return -1;
		}
//	        反摺點index判斷
		int breakpoint = findBreakPoint(nums);

//	         例外情況  target > numsMax or <  numsMin
		if (target > nums[breakpoint] || target < nums[(breakpoint + 1) % (nums.length)])
			return -1;

//	        區間判斷  要用前段或後段進行二分搜尋
		int startIdx;
		int endIdx;
		if (target >= nums[0]) {
//	       使用前段
			startIdx = 0;
			endIdx = breakpoint;
		} else {

//	        使用後段
			startIdx = breakpoint + 1;
			endIdx = nums.length - 1;
		}

//	         結束條件 中位數==target 或是 查詢範圍只剩兩個數字
		while (nums[(startIdx + endIdx) / 2] != target && Math.abs(startIdx - endIdx) > 1) {
			if (nums[(startIdx + endIdx) / 2] > target) {
//	                    排除中位數
				endIdx = ((startIdx + endIdx) / 2) - 1;
			} else {
//	                    包含中位數
				startIdx = (startIdx + endIdx) / 2;
			}
		}

//	當  查詢陣列剩兩位數 or 中位數等同target 進行檢核
		if (nums[startIdx] == target)
			return startIdx;
		if (nums[endIdx] == target)
			return endIdx;
		return nums[(startIdx + endIdx) / 2] != target ? -1 : (startIdx + endIdx) / 2;

	}

	// 反摺點查詢
	public int findBreakPoint(int[] arr) {

		int startIdx = 0;
		int endIdx = arr.length - 1;

		if (arr[endIdx] > arr[startIdx]) {
			return endIdx;
		}
		while (arr[(startIdx + endIdx) / 2] < arr[((startIdx + endIdx) / 2) + 1]) {

			if (arr[(startIdx + endIdx) / 2] < arr[startIdx]) {
				// 反摺點靠近前段 移動判斷結束index
				endIdx = (startIdx + endIdx) / 2;
			} else {
				// 反摺點靠近後段 移動判斷起始index
				startIdx = (startIdx + endIdx) / 2;
			}
		}
		return (startIdx + endIdx) / 2;
	}

}
