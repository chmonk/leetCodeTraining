package cycle11_search_tree;

public class Search_in_Rotated_Sorted_Array_33 {

	/**
	 * 1.��ı�Ѥ����� 2.�Dlog(N) +debug��F1h..... �G���k�v�B�Y��d�򪺱���(�U�����d�߱���O�_�]�t������ƭn�Q�o���M��)
	 * �ֶ]�X���L�Ϊ��j�鴣�ɤ��ְO����ϥήĲv
	 */

//	1.��ı�� O(N)
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

//	2. �ϺP�I+ �G���kO(logN)
	public int search_1(int[] nums, int target) {

//	        �}�C�j�p�p��3�L�ϺP�I=>�����P�_
		if (nums.length < 3) {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == target)
					return i;
			}
			return -1;
		}
//	        �ϺP�Iindex�P�_
		int breakpoint = findBreakPoint(nums);

//	         �ҥ~���p  target > numsMax or <  numsMin
		if (target > nums[breakpoint] || target < nums[(breakpoint + 1) % (nums.length)])
			return -1;

//	        �϶��P�_  �n�Ϋe�q�Ϋ�q�i��G���j�M
		int startIdx;
		int endIdx;
		if (target >= nums[0]) {
//	       �ϥΫe�q
			startIdx = 0;
			endIdx = breakpoint;
		} else {

//	        �ϥΫ�q
			startIdx = breakpoint + 1;
			endIdx = nums.length - 1;
		}

//	         �������� �����==target �άO �d�߽d��u�Ѩ�ӼƦr
		while (nums[(startIdx + endIdx) / 2] != target && Math.abs(startIdx - endIdx) > 1) {
			if (nums[(startIdx + endIdx) / 2] > target) {
//	                    �ư������
				endIdx = ((startIdx + endIdx) / 2) - 1;
			} else {
//	                    �]�t�����
				startIdx = (startIdx + endIdx) / 2;
			}
		}

//	��  �d�߰}�C�Ѩ��� or ����Ƶ��Ptarget �i���ˮ�
		if (nums[startIdx] == target)
			return startIdx;
		if (nums[endIdx] == target)
			return endIdx;
		return nums[(startIdx + endIdx) / 2] != target ? -1 : (startIdx + endIdx) / 2;

	}

	// �ϺP�I�d��
	public int findBreakPoint(int[] arr) {

		int startIdx = 0;
		int endIdx = arr.length - 1;

		if (arr[endIdx] > arr[startIdx]) {
			return endIdx;
		}
		while (arr[(startIdx + endIdx) / 2] < arr[((startIdx + endIdx) / 2) + 1]) {

			if (arr[(startIdx + endIdx) / 2] < arr[startIdx]) {
				// �ϺP�I�a��e�q ���ʧP�_����index
				endIdx = (startIdx + endIdx) / 2;
			} else {
				// �ϺP�I�a���q ���ʧP�_�_�lindex
				startIdx = (startIdx + endIdx) / 2;
			}
		}
		return (startIdx + endIdx) / 2;
	}

}
