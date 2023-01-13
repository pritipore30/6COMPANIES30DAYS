package solution;

import java.util.ArrayList;
import java.util.List;


public class NumberofMatchingSubsequences {
	public int numMatchingSubseq(String s, String[] words) {
		int ans = 0;
		List<Pair<Integer, Integer>>[] bucket = new List[26];

		for (int i = 0; i < 26; ++i)
			bucket[i] = new ArrayList<>();

		for (int i = 0; i < words.length; ++i)
			bucket[words[i].charAt(0) - 'a'].add(new Pair<>(i, 0));

		for (final char c : s.toCharArray()) {
			List<Pair<Integer, Integer>> prevBucket = bucket[c - 'a'];
			bucket[c - 'a'] = new ArrayList<>();
			for (Pair<Integer, Integer> pair : prevBucket) {
				final int i = pair.getKey();
				final int j = pair.getValue() + 1;
				if (j == words[i].length()) 
					++ans;
				else
					bucket[words[i].charAt(j) - 'a'].add(new Pair<>(i, j));
			}
		}

		return ans;
	}
	public static void main(String[] args) {
		String s = "abcde";
		String[] words = {"a","bb","acd","ace"};
		System.out.println(numMatchingSubseq(s, words));
	}

}
