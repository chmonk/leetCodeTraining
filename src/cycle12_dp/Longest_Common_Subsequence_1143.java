package cycle12_dp;

public class Longest_Common_Subsequence_1143 {

	/*
	 * 一開始沒想到遞增條件,看hint才懂
	 * 
	 * // if common: text1[i]==text2[j]=> demo[i][j] = demo[i-1][j-1]+1 // else
	 * uncommon: text1[i]!=text2[j] => demo[i][j]=max(demo[i-1][j],demo[i][j-1]) //
	 * init demo[0][0]=0
	 * 
	 */

	public int longestCommonSubsequence(String text1, String text2) {
		int[][] demo = new int[text1.length() + 1][text2.length() + 1];

		// if common: text1[i]==text2[j]=> demo[i][j] = demo[i-1][j-1]+1
		// else uncommon: text1[i]!=text2[j] =>
		// demo[i][j]=max(demo[i-1][j],demo[i][j-1])
		// init demo[0][0]=0

		for (int i = 1; i <= text1.length(); i++) {
			int idx_i = (int) text1.charAt(i - 1);
			for (int j = 1; j <= text2.length(); j++) {
				int idx_j = (int) text2.charAt(j - 1);
				if (idx_i == idx_j)
					demo[i][j] = demo[i - 1][j - 1] + 1;
				else {
					demo[i][j] = Math.max(demo[i - 1][j], demo[i][j - 1]);
				}
			}
		}
		return demo[text1.length()][text2.length()];
	}
}
