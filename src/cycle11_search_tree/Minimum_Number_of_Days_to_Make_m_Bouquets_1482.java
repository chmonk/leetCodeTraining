package cycle11_search_tree;

public class Minimum_Number_of_Days_to_Make_m_Bouquets_1482 {

	public int minDays(int[] bloomDay, int m, int k) {

		if (m * k > bloomDay.length)
			return -1;

		int lower = 1;

		int upper = 1_000_000_000;

		while (lower < upper) {

			int med = lower + (upper - lower) / 2;

			int bouq_num = 0;

			t1: for (int i = 0; i < bloomDay.length; i++) {

				int j = i;

				t2: while (j < bloomDay.length && med >= bloomDay[j]) {

					if (j - i + 1 >= k) {
						bouq_num++;
						break t2;
					}
					j++;
				}
				i = j;

				if (bouq_num >= m) {
					break t1;
				}

			}

			if (bouq_num >= m) {
				upper = med;
			} else {
				lower = med + 1;
			}

		}

		return lower;

	}
}
