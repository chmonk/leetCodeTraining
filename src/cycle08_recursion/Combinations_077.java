package cycle08_recursion;

import java.util.LinkedList;
import java.util.List;

public class Combinations_077 {


	public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> ans = new LinkedList<>();

		helper(ans, n, k, new LinkedList<Integer>(), 1);

		return ans;

	}

	private void helper(List<List<Integer>> ans, int n, int k, LinkedList<Integer> cur, int idx) {
		if (k == 0) {
			ans.add(new LinkedList<>(cur));
            return;
		}

		for (int i = idx; i <= n-k+1; i++) {
			cur.add(i);
			helper(ans, n, k - 1, cur, i + 1);
			cur.remove(cur.size() - 1);
		}

	}

}
