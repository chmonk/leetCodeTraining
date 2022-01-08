package cycle06_Stack_Queue_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues_225 {

	static class MyStack {
		Queue<Integer> q;
		Queue<Integer> st;
		Integer topelement;

		public MyStack() {
			q = new LinkedList<Integer>();
			st = new LinkedList<Integer>();
		}

		public void push(int x) {
			q.offer(x);
			topelement = x;

		}

		public int pop() {
			int last = 0;
			while (q.peek() != null) {
				last = q.poll();
				if (q.peek() != null) {
					topelement = last;
					st.offer(last);
				}
			}

			Queue<Integer> ex;
			ex = q;
			q = st;
			st = ex;

			return last;
		}

		public int top() {
			return topelement;
		}

		public boolean empty() {
			return q.size() == 0;
		}
	}

	static public void main(String[] args) {
		MyStack test = new MyStack();

		test.push(1);
		test.push(2);
		System.out.println(test.pop());
		System.out.println(test.top());
		System.out.println(test.empty());
	}

	static class MyStack_oneQ {
		Queue<Integer> q;
		Integer topelement;

		public MyStack_oneQ() {
			q = new LinkedList<Integer>();
		}

		public void push(int x) {
			q.offer(x);
			topelement = x;
		}

		public int pop() {

			Integer last = 0;

			int count = q.size();

			for (int i = count; i > 0; i--) {
				last = q.poll();
				if (i == 2) {
					topelement = last;
				}
				if (i != 1) {
					q.offer(last);
				}
			}

			return last;
		}

		public int top() {
			return topelement;
		}

		public boolean empty() {
			return q.size() == 0;
		}
	}

}
