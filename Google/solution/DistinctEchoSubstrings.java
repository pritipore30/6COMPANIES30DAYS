package solution;

import java.util.HashSet;
import java.util.Set;

public class DistinctEchoSubstrings {
	public static int distinctEchoSubstrings(String text) {
		Set<String> result = new HashSet<>();

		for (int k = 1; k <= text.length() / 2; ++k) {
			int same = 0;
			for (int l = 0, r = k; r < text.length(); ++l, ++r) {
				if (text.charAt(l) == text.charAt(r)) {
					++same;
				} else {
					same = 0;
				}
				if (same == k) {
					result.add(text.substring(l - k + 1, l + 1));
					--same;
				}
			}
		}

		return result.size();
	}

	public static void main(String[] args) {
		String text = "abcabcabc";
		System.out.println(distinctEchoSubstrings(text));
	}
}
