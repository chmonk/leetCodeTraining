package cycle07_recursion;

import java.util.LinkedList;
import java.util.List;

public class subsets_78 {

	

	public List<List<Integer>> subsets(int[] nums) {
		
		List<List<Integer>> ans = new LinkedList<>();

		LinkedList<Integer> hollow = new LinkedList<Integer>();

		ans.add(hollow);

		helper(nums, 0, ans);

		return ans;

	}

	private void helper(int[] nums, int idx, List<List<Integer>> ans) {

		if (idx >= nums.length)
			return;

		int size = ans.size();

		for (int i = 0; i < size; i++) {
			List<Integer> a= new LinkedList<Integer>(ans.get(i));
			a.add(nums[idx]);
			ans.add(a);
		}
		
		helper(nums, ++idx, ans);

	}

}
