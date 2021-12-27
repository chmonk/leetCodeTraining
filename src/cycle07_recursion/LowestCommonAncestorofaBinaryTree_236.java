package cycle07_recursion;

public class LowestCommonAncestorofaBinaryTree_236 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null)
			return null;

		if (root.val == p.val || root.val == q.val)
			return root;

		else {
			TreeNode left = lowestCommonAncestor(root.left, p, q);
			TreeNode right = lowestCommonAncestor(root.right, p, q);

			if (left != null && right != null) {
				return root;
			} else if (left != null) {
				return left;
			} else {
				return right;
			}

		}

	}


}
