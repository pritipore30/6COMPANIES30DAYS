package solution;

import java.util.ArrayList;
import java.util.List;

public class MaximumGoodPeopleBasedonStatements {

	public static int maximumGood(int[][] statements) {
		dfs(statements, new ArrayList<>(), 0, 0);
		return ans;
	}

	private static int ans = 0;

	private static void dfs(int[][] statements, List<Integer> good, int i, int count) {
		if (i == statements.length) {
			if (isValid(statements, good))
				ans = Math.max(ans, count);
			return;
		}

		good.add(0);
		dfs(statements, good, i + 1, count);
		good.set(good.size() - 1, 1);
		dfs(statements, good, i + 1, count + 1);
		good.remove(good.size() - 1);
	}

	private static boolean isValid(int[][] statements, List<Integer> good) {
		for (int i = 0; i < good.size(); ++i) {
			if (good.get(i) == 0)
				continue;
			for (int j = 0; j < statements.length; ++j) {
				if (statements[i][j] == 2)
					continue;
				if (statements[i][j] != good.get(j))
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int [][] statements = {{2,1,2},{1,2,2},{2,0,2}};
		System.out.println(maximumGood(statements));
		
	}

}
