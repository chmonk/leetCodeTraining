package cycle06_Stack_Queue_Tree;

import java.util.Stack;

public class ImplementQueueusingStacks_232 {

	class MyQueue {
		Stack<Integer> st1;
		Stack<Integer> st2;
		int size = 0;

		public MyQueue() {
			st1 = new Stack<Integer>();
			st2 = new Stack<Integer>();
		}

		public void push(int x) {

			while (!st1.isEmpty()) {
				st2.push(st1.pop());
			}
			st2.push(x);

			size = 0;

			while (!st2.isEmpty()) {
				st1.push(st2.pop());
				size++;
			}

		}

		public int pop() {
			size--;
			return st1.pop();
		}

		public int peek() {
			return st1.peek();
		}

		public boolean empty() {

			return size == 0;

		}
	}
}
