package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWordsA {
	public static List<String> topKFrequent(String[] words, int k) {
		final int n = words.length;
		List<String> ans = new ArrayList<>();
		List<String>[] bucket = new List[n + 1];
		Map<String, Integer> count = new HashMap<>();

		for (final String word : words)
			count.put(word, count.getOrDefault(word, 0) + 1);

		for (final String word : count.keySet()) {
			final int freq = count.get(word);
			if (bucket[freq] == null)
				bucket[freq] = new ArrayList<>();
			bucket[freq].add(word);
		}

		for (int freq = n; freq > 0; --freq)
			if (bucket[freq] != null) {
				Collections.sort(bucket[freq]);
				for (final String word : bucket[freq]) {
					ans.add(word);
					if (ans.size() == k)
						return ans;
				}
			}

		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		int k = 2;
		System.out.println(topKFrequent(words, k));
	}
}
