package cycle05_LinkedList;

public class LinkedListCycleII_142 {

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

	public ListNode detectCycle(ListNode head) {
		ListNode x = head;
		ListNode y = head;

		while (x != null && x.next != null) {
			x = x.next.next;
			y = y.next;
			if (x == y) {
				while (y != head) {
					y = y.next;
					head = head.next;
				}
				return y;
			}
		}

		return null;
		
		//https://leetcode.com/problems/remove-duplicates-from-sorted-list/discuss/28625/3-Line-JAVA-recursive-solution

	}
}
