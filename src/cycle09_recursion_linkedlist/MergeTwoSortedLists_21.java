package cycle09_recursion_linkedlist;

public class MergeTwoSortedLists_21 {
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
	 * ListNode next) { this.val = val; this.next = next; } }
	 */
	class Solution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null) {
				return l2;
			}
			if (l2 == null) {
				return l1;
			}

			// define head
			ListNode head;

			ListNode left = l1.val > l2.val ? l1 : l2;

			if (l1.val > l2.val) {
				head = l2;
				l2 = l2.next;
			} else {
				head = l1;
				l1 = l1.next;
			}

			ListNode cur = head;

			// while looping the two list
			while (l1 != null && l2 != null) {
				if (l1.val > l2.val) {
					cur.next = l2;
					l2 = l2.next;
				} else {
					cur.next = l1;
					l1 = l1.next;
				}
				cur = cur.next;
			}
			if (l1 == null) {
				cur.next = l2;
			}
			if (l2 == null) {
				cur.next = l1;
			}

			return head;
		}
	}

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
}
