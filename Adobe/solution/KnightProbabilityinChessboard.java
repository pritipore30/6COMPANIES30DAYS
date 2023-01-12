package solution;

import java.util.Arrays;

public class KnightProbabilityinChessboard {
	public static double knightProbability(int n, int k, int row, int column) {
		final double kProb = 0.125;
		final int[][] dirs = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
		double[][] dp = new double[n][n];
		dp[row][column] = 1.0;

		for (int z = 0; z < k; ++z) {
			double[][] newDp = new double[n][n];
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (dp[i][j] > 0.0) {
						for (int[] dir : dirs) {
							final int x = i + dir[0];
							final int y = j + dir[1];
							if (x < 0 || x >= n || y < 0 || y >= n)
								continue;
							newDp[x][y] += dp[i][j] * kProb;
						}
					}
				}
			}
			dp = newDp;
		}
		double ans = 0.0;
		for (double[] r : dp)
			ans += Arrays.stream(r).sum();

		return ans;
	}
	public static void main(String[] args) {
		int n = 3;
		int k = 2;
		int row = 0;
		int column = 0;
		System.out.println(knightProbability(n, k, row, column));
	}

}
