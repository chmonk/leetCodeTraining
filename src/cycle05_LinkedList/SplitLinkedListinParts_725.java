package cycle05_LinkedList;

public class SplitLinkedListinParts_725 {
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

	public static void main(String[] args) {
//		splitListToParts(null, 5);
	}

	static public ListNode[] splitListToParts_clean(ListNode head, int k) {

		int count = 0;

		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			count++;
		}

		ListNode[] ans = new ListNode[k];

		int eq = count / k;
		int lef = count % k;

		ListNode h = head;
		ListNode temp;
		for (int i = 0; i < k && h != null; i++) {

			ans[i] = h;
			int bonus = lef > 0 ? 1 : 0;
			for (int j = 0; j < eq + bonus - 1; j++) {
				h = h.next;
			}
			temp = h;
			h = h.next;
			temp.next = null;
			lef--;

		}
		return ans;
	}

	static public ListNode[] splitListToParts_origin(ListNode head, int k) {

		int count = 0;

		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			count++;
		}

		int eq = count / k;
		int lef = count % k;
		int[] num = new int[k];
		for (int i = 0; i < num.length; i++) {
			num[i] = eq;
		}
		for (int j = 0; j < lef; j++) {
			num[j]++;
		}

		ListNode[] ans = new ListNode[k];

		ListNode h = head;
		ListNode m;

		for (int i = 0; i < num.length; i++) {

			int count_each = 0;
			ans[i] = h;
			while (count_each < num[i]) {
				m = h;
				h = h.next;

				if (count_each + 1 == num[i]) {
					m.next = null;
				}
				count_each++;
			}

		}

		return ans;
	}
}
