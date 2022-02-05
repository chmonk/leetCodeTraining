package cycle09_recursion_linkedlist;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix_54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new LinkedList<Integer>();

		int m = matrix.length - 1;

		int n = matrix[0].length - 1;

		recursionHelp(0, 0, n, m, res, matrix);

		return res;
	}

	private void recursionHelp(int start_x, int start_y, int end_x, int end_y, List<Integer> res, int[][] matrix) {

		if ((start_x > end_x) || (start_y > end_y)) {
			return;
		}

// rightside
		for (int i = start_x; i <= end_x; i++) {
			res.add(matrix[start_y][i]);
		}
// downside
		for (int i = start_y + 1; i < end_y; i++) {
			res.add(matrix[i][end_x]);
		}
// leftside
		if (start_y != end_y) {
			for (int i = end_x; i >= start_x; i--) {
				res.add(matrix[end_y][i]);
			}
		}
// upside
		if (start_x != end_x) {
			for (int i = end_y - 1; i > start_y; i--) {
				res.add(matrix[i][start_x]);
			}
		}

		recursionHelp(start_x + 1, start_y + 1, end_x - 1, end_y - 1, res, matrix);

	}
}
