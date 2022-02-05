package cycle13_dp2;

import java.util.HashMap;

public class Minimum_Number_of_Days_to_Eat_N_Oranges_1553 {

	// 遞迴+記憶=>dp
//	看成走幾個一步加上剩下倍數步伐
	HashMap<Integer, Integer> map = new HashMap<>() {
		{
			put(2, 2);
			put(1, 1);
			put(0, 0);
		}
	};

	public int minDays(int n) {

		if (map.get(n) == null) {
			int ns = Math.min((n % 2) + minDays(n / 2) + 1, (n % 3) + minDays(n / 3) + 1);
			map.put(n, ns);
		}

		return map.get(n);
	}
}
