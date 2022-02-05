package cycle11_search_tree;

import java.util.HashMap;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	HashMap<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return helper(preorder, inorder, 0, preorder.length, 0, inorder.length);

	}

	private int help(int target, int[] inorder, int inlow, int inhigh) {

		return map.get(target);
	}

	private TreeNode helper(int[] preorder, int[] inorder, int prelow, int prehigh, int inlow, int inhigh) {

		if (prelow > prehigh || inlow > inhigh)
			return null;

		int in_idx = help(preorder[prelow], inorder, inlow, inhigh);

		TreeNode t = new TreeNode(preorder[prelow]);

		// inorder part can be split to left and right tree;
		// preorder recursive +1 for find the root in inorder
		// next round preorder upperlimit is restrict by the count of inoreder
		// start-inorder root;

		int leftTreeLen = in_idx - inlow;

		t.left = helper(preorder, inorder, prelow + 1, prelow + leftTreeLen, inlow, in_idx);

		t.right = helper(preorder, inorder, prelow + leftTreeLen + 1, prehigh, in_idx + 1, inhigh);

		return t;
	}
}
