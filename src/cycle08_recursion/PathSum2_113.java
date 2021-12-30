package cycle08_recursion;

import java.util.LinkedList;
import java.util.List;

public class PathSum2_113 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<List<Integer>> res = new LinkedList<List<Integer>>();

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

		helper(root, targetSum, new LinkedList<Integer>());

		return res;
	}

	private void helper(TreeNode root, int targetSum, LinkedList<Integer> l) {
		if (root == null)
			return;


		int curTar = targetSum - root.val;

		if (root.left == root.right) {
			if (curTar == 0) {
				LinkedList<Integer> copy = new LinkedList<>(l);
				copy.add(root.val);
				res.add(copy);
			}
		} else {
			l.add(root.val);
			helper(root.left, curTar, l);
			helper(root.right, curTar, l);
			l.remove(l.size()-1);
		}

	}

}
