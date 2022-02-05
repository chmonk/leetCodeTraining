package cycle03_map_and_set;

import java.util.HashMap;

public class SingleNumber_iii_260 {
	public int[] singleNumber(int[] nums) {
		HashMap<Integer, Integer> res = new HashMap<>();

		for (int num : nums) {

			if (res.get((Integer) num) != null) {
				res.remove((Integer) num);
			} else {
				res.put((Integer) num, 0);
			}
		}

		int[] ans = new int[2];
		int time = 0;
		for (Integer k : res.keySet()) {
			ans[time++] = k;
		}

		return ans;
	}
}
