package cycle11_search_tree;

public class Find_the_Smallest_Divisor_Given_a_Threshold_1283 {

	public int smallestDivisor(int[] nums, int threshold) {
		int left = 1;

		int right = 0;

		for (int num : nums) {
			right = Math.max(num, right);
		}

		while (left < right) {

			int med = left + (right - left) / 2;

			int count = 0;

			fir: for (int num : nums) {
				int res = cal(num, med);
				count += res;
				if (count > threshold) {
					break fir;
				}
			}

			if (count > threshold) {
				left = med + 1;
			} else {
				right = med;
			}

		}

		return left;

	}

	private int cal(int num, int devisor) {

		int r = num / devisor;

		if (num % devisor != 0) {
			return r + 1;
		} else {
			return r;
		}
	}

}
