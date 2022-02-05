package cycle10_TreexBFS_DFS;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestPathinBinaryMatrix_1091 {

	/**
	 * 嘗試用dfs,失敗看解答重用bfs解, 找最短路徑(排除特性的)不適合用dfs(因dfs要run完所有可能才能解)需消耗多餘記憶體跟嘗試次數
	 */
	final int[][] path = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 },
			{ -1, 1 } };

	public int shortestPathBinaryMatrix(int[][] grid) {

		int m = grid.length - 1;

		int n = grid[0].length - 1;

		int count_bfs = 0;

		int[][] visited = new int[m + 1][n + 1];

		if (grid[0][0] == 1 || grid[m][n] == 1) {
			return -1;
		}

		Deque<int[]> record = new LinkedList<int[]>();

		record.add(new int[] { 0, 0 });
		visited[0][0] = 1;

		while (record.peek() != null) {

			int size = record.size();

			for (int j = 0; j < size; j++) {

				int[] cur = record.poll();

				int next_x = cur[0];
				int next_y = cur[1];

				if (next_x == m && next_y == n) {
					return ++count_bfs;
				}

				for (int i = 0; i < path.length; i++) {
					next_x = cur[0] + path[i][0];
					next_y = cur[1] + path[i][1];

					if (next_x >= 0 && next_x <= m && next_y >= 0 && next_y <= n && visited[next_x][next_y] != 1
							&& grid[next_x][next_y] != 1) {
						record.add(new int[] { next_x, next_y });
						visited[next_x][next_y] = 1;
					}

				}

			}
			count_bfs++;

		}

		return -1;
	}
}
