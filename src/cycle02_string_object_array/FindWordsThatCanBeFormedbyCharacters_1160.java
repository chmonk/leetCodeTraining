package cycle02_string_object_array;

public class FindWordsThatCanBeFormedbyCharacters_1160 {

	public int countCharacters(String[] words, String chars) {
		// use hashSet int[26]
		int[] chars_component = new int[26];

		// chars component
		for (int i = 0; i < chars.length(); i++) {
			chars_component[chars.charAt(i) - 97]++;
		}

		int res = 0;

		for (String word : words) {

			int[] test_component = new int[26];

			boolean check_resault = true;
			for (int i = 0; i < word.length(); i++) {
				test_component[word.charAt(i) - 97]++;

				if (test_component[word.charAt(i) - 97] > chars_component[word.charAt(i) - 97]) {
					check_resault = false;
					break;
				}
			}

			if (check_resault) {
				res += word.length();
			}

		}

		return res;
	}

}
