package cycle05_LinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesfromSortedList_83 {

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

	public ListNode deleteDuplicates(ListNode head) {

		Set<Integer> set = new HashSet<>();

		ListNode cur = head;
		ListNode temp = new ListNode();

		while (cur != null) {

			if (set.contains(cur.val)) {
				temp.next = cur.next;
				cur.next = null;
				cur = temp;
			} else {
				set.add(cur.val);
			}
			temp = cur;
			cur = cur.next;

		}

		return head;

	}

	public ListNode deleteDuplicates_ori(ListNode head) {

		ListNode cur = head;
		ListNode temp = new ListNode(Integer.MIN_VALUE); // must outside of constrain range or hollow head mess with 0

		while (cur != null) {

			if (temp.val == cur.val) {
				temp.next = cur.next;
				cur.next = null;
				cur = temp.next;
			}
			temp = cur;
			cur = cur.next;
		}

		return temp;
	}
	
	
	public ListNode deleteDuplicates_recursive_cool(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
}

}
