package solution;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {
	public static int minMutation(String startGene, String endGene, String[] bank) {
		Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
		if (!bankSet.contains(endGene)) {
			return -1;
		}

		int ans = 0;
		Queue<String> q = new ArrayDeque<>(Arrays.asList(startGene));

		while (!q.isEmpty()) {
			++ans;
			for (int sz = q.size(); sz > 0; --sz) {
				StringBuilder sb = new StringBuilder(q.poll());
				for (int j = 0; j < sb.length(); ++j) {
					final char cache = sb.charAt(j);
					for (final char c : new char[] { 'A', 'C', 'G', 'T' }) {
						sb.setCharAt(j, c);
						final String word = sb.toString();
						if (word.equals(endGene))
							return ans;
						if (bankSet.contains(word)) {
							bankSet.remove(word);
							q.offer(word);
						}
					}
					sb.setCharAt(j, cache);
				}
			}
		}
		return -1;
	}
	public static void main(String[] args ) {
		String startGene = "AACCGGTT";
		String endGene = "AACCGGTA";
		String[] bank = {"AACCGGTA"};
		System.out.println(minMutation(startGene, endGene, bank));
	}

}
