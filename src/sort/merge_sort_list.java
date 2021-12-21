package sort;

public class merge_sort_list {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode findMiddle(ListNode n) {
		ListNode a = n;
		ListNode b = n;

		while (b != null && b.next != null) {
			a = a.next;
			b = b.next.next;
		}
		return a;
	}

	public ListNode mergesort(ListNode m) {

		ListNode middle = findMiddle(m);
		ListNode start2 = middle.next;
		middle.next = null;

		ListNode left = mergesort(m);
		ListNode right = mergesort(m);

		return merge(left, right);

	}

	public ListNode merge(ListNode left, ListNode right) {

		ListNode head = new ListNode();

		while (left != null && right != null) {

		}

		return head.next;
	}

}