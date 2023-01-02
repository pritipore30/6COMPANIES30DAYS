package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum3 {
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();
		combination(result, curr, k, 1, n);
		return result;

	}

	public static void combination(List<List<Integer>> result, List<Integer> curr, int k, int start, int remainingSum) {

		if (remainingSum == 0 && curr.size() == k) {
			result.add(new ArrayList<Integer>(curr));
			return;
		}
		if (remainingSum < 0) {
			return;
		}
		for (int i = start; i <= 9; i++) {
			curr.add(i);
			combination(result, curr, k, i + 1, remainingSum - i);
			curr.remove(curr.size() - 1);
		}
	}

	public static void main(String[] args) {
		int k = 3;
		int n = 9;
		List<List<Integer>> result = combinationSum3(k, n);
		System.out.println(result.toString());

	}

}
