package cycle07_recursion;

public class BinaryTreeMaximumPathSum_124 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {

		helper(root);
		return max;

	}

	private int helper(TreeNode root) {
		if (root == null)
			return 0;

		int left = Math.max(0, helper(root.left));
		int right = Math.max(0, helper(root.right));
		max = Math.max(max, root.val + left + right);

		int re = root.val + Math.max(left, right);

		return re;

	}

}
