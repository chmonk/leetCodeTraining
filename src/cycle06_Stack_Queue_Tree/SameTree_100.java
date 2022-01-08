package cycle06_Stack_Queue_Tree;

public class SameTree_100 {
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

	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == q) {
			return true;
		} else if (p != null && q != null) {
            if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
          } 
		}
        
        return false;

	}
}
