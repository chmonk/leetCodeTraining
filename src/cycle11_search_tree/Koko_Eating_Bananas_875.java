package cycle11_search_tree;

public class Koko_Eating_Bananas_875 {

	public int minEatingSpeed(int[] piles, int h) {

		int left = 1;

		int right = piles[0];

		for (int pile : piles) {
			right = Math.max(right, pile);
		}

		int ans = 0;

		while (left <= right) {

			int med = left + (right - left) / 2;

			int hour = 0;

			loop: for (int pile : piles) {
				hour += cal(pile, med);
				if (hour > h) {
					break loop;
				}
			}

			if (hour > h) {
				left = med + 1;
			} else {
				ans = med;
				right = med - 1;
			}

		}

		return ans;

	}

	private int cal(int pile, int devisor) {

		int count = pile / devisor;

		if (pile % devisor == 0) {
			return count;
		} else {
			return ++count;
		}
	}

}
