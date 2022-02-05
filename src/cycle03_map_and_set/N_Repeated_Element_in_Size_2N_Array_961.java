package cycle03_map_and_set;

import java.util.HashMap;

public class N_Repeated_Element_in_Size_2N_Array_961 {
	public int repeatedNTimes(int[] A) {
		HashMap<Integer, Integer> check = new HashMap<>();

		for (int num : A) {
			if (check.get(num) != null) {
				return num;
			} else {
				check.put((Integer) num, 0);
			}
		}

		return 0;
	}
}
