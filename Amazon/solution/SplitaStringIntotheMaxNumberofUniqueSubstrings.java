package solution;

public class SplitaStringIntotheMaxNumberofUniqueSubstrings {
	public int maxUniqueSplit(String S) {
		return maxUnique(S, new HashSet<String>());
	}

	public int maxUnique(String S, Set<String> set) {
		int max = 0;
		for (int i = 1; i <= S.length(); i++) {
			String tmp = S.substring(0, i);
			if (!set.contains(tmp)) {
				set.add(tmp);
				max = Math.max(max, maxUnique(S.substring(i), set) + 1);
				set.remove(tmp);
			}
		}
		return max;
	}
}
