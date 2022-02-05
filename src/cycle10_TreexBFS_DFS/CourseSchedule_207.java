package cycle10_TreexBFS_DFS;

import java.util.LinkedList;
import java.util.Stack;

public class CourseSchedule_207 {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// cycle detect
		LinkedList<Integer>[] prerequisites_record = new LinkedList[numCourses];

		int[] verifyied_course = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			prerequisites_record[i] = new LinkedList<>();
		}

		// build graph
		for (int i = 0; i < prerequisites.length; i++) {

			int course = prerequisites[i][0];
			int pre_course = prerequisites[i][1];

			// 0=>1 該課程為哪幾門的前置
			prerequisites_record[pre_course].add(course);

			// 該課程剩多少前置
			verifyied_course[course]++;
		}

		Stack<Integer> canaccessCourse = new Stack<>();
		// build no prequisite course
		for (int i = 0; i < verifyied_course.length; i++) {
			if (verifyied_course[i] == 0) {
				canaccessCourse.push(i);
			}
		}

		int all_limit = prerequisites.length;

		while (!canaccessCourse.isEmpty()) {
			int cur_access = canaccessCourse.pop();

			for (int re : prerequisites_record[cur_access]) {
				all_limit--;
				if (--verifyied_course[re] == 0) {
					canaccessCourse.add(re);
				}
			}

		}

		return all_limit == 0;
	}
}
