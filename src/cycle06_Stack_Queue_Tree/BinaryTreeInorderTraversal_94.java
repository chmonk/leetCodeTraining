package cycle06_Stack_Queue_Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {

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

	List<Integer> ans = new LinkedList<Integer>();

	public List<Integer> inorderTraversal(TreeNode root) {
//  inorder 左中右 preorder 中左右  postorder 左右中

		inorder_recursive(root);

		inorder_while(root);

		return ans;
	}

	private void inorder_while(TreeNode root) {

		Stack<TreeNode> st = new Stack<>();

		TreeNode cur = root;

		while (!st.isEmpty() || cur != null) {

			while (cur != null) {
                st.add(cur);
                cur = cur.left;
			}

			cur = st.pop();
			ans.add(cur.val);
            
			cur = cur.right;
          

		}

	}

	private void inorder_recursive(TreeNode root) {

		if (root == null)
			return;

		if (root.left != null) {
			inorder_recursive(root.left);
		}

		ans.add(root.val);

		if (root.right != null) {
			inorder_recursive(root.right);
		}

	}
}