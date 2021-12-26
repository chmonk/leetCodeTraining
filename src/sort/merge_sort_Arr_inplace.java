package sort;

public class merge_sort_Arr_inplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] mergesort(int[] arr) {
		// split helper
		split(arr, 0, arr.length - 1);

		return arr;
	}

	private void split(int[] arr, int s, int e) {

		if (s >= e) {
			return;
		}
		// middle
		int middle = s + (e - s) / 2;

		// split
		split(arr, s, middle);
		split(arr, middle + 1, e);

		// conquer
		merge(arr, s, middle, e);

	}

	private void merge(int[] arr, int s, int middle, int e) {

		int st2 = middle + 1;
		if (arr[middle] <= arr[st2]) {
			return;
		}

		while (s <= middle && st2 <= e) {  //equal condition to compare the last one

			if (arr[s] > arr[st2]) {
				int val = arr[st2];
				int idx = st2;
				while (s < idx) {
					arr[idx] = arr[--idx];
				}
				arr[s] = val;

				middle++;
				st2++;
			}
			s++;
		}

	}

}
