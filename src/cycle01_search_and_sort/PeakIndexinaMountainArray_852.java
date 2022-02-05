package cycle01_search_and_sort;

public class PeakIndexinaMountainArray_852 {

	
//	1.O(N): ½aÁ|

	 public static Integer trace_mountain(int[] arr) {

	 if (arr.length > 0) {
	        for (int i = 1; i <= arr.length - 2; i++) {

	          int t2 = arr[i + 1] - arr[i] > 0 ? 1 : -1;
	          int t3 = (arr[i] - arr[i - 1]) > 0 ? 1 : -1;

	          if (t2 * t3 < 0) {
	              return i;
	          }
	    }
	 }
	      return -1;
	 }

//	2. O(log(N)): »¼°j©î¥b
//	¥Îstart,end ¬ö¿ıÆ[¹îªº½d³ò

	 public static Integer trace_mountain_calfun(int[] arr) {
	                return split_mountain(arr, 0, arr.length - 1);
	 }

	 public static int split_mountain(int[] arr, int start, int end) {

	              int center = (end + start) / 2;

	              int t1 = arr[center] - arr[center - 1] > 0 ? 1 : -1;
	              int t2 = arr[center + 1] - arr[center] > 0 ? 1 : -1;

	              if (t2 * t1 < 0) {
	                      return center; //µª®×
	              } else if (t2 > 0) {
	                      return split_mountain(arr, center, end);  //§ä§À¤Ú
	              } else {
	                      return split_mountain(arr, start, center); //§äÀY
	              }

	 }
}
