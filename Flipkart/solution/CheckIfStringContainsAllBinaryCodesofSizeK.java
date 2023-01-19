package solution;

import java.util.HashSet;

public class CheckIfStringContainsAllBinaryCodesofSizeK {
	public static boolean hasAllCodes(String s, int k) {
		HashSet<String> hashSet = new HashSet<>();
		int required = (int) Math.pow(2, k);
		for (int i = k; i <= s.length(); i++) {
			String temp = s.substring(i - k, i);
			if (!hashSet.contains(temp)) {
				hashSet.add(temp);
			}
		}
		if (hashSet.size() == required) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		String s = "00110110";
		int k = 2;
		System.out.println(hasAllCodes(s,k));
	}

}
