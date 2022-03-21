package cycle06_Stack_Queue_Tree;

import java.util.Stack;

public class Remove_Duplicate_Letters_316 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println('a' == 97);

	}

	public String removeDuplicateLetters(String s) {

		int[] count = new int[26];

		boolean[] used = new boolean[26];

		for (byte b1 : s.getBytes()) {
			count[b1 - 97]++;
		}

		Stack<Character> res = new Stack<>();

		for (byte b1 : s.getBytes()) {

			count[b1 - 97]--;

			if (used[b1 - 97]) {
				continue;
			}

			used[b1 - 97] = true;

			while (!res.isEmpty() && res.peek() > b1 && count[res.peek() - 97] > 0) {
				used[res.pop() - 97] = false;
			}

			res.push((char) b1);
		}
		
		StringBuilder ans = new StringBuilder();
		
		while(!res.isEmpty()) {
			ans.insert(0, res.pop());			
		}

		return ans.toString();

	}

}
