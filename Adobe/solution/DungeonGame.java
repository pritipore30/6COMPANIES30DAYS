package solution;

import java.util.Arrays;

public class DungeonGame {
	public static int calculateMinimumHP(int[][] dungeon) {
		final int m = dungeon.length;
		final int n = dungeon[0].length;
		int[][] hp = new int[m + 1][n + 1];
		Arrays.stream(hp).forEach(A -> Arrays.fill(A, Integer.MAX_VALUE));
		hp[m][n - 1] = 1;
		hp[m - 1][n] = 1;

		for (int i = m - 1; i >= 0; --i) {
			for (int j = n - 1; j >= 0; --j) {
				hp[i][j] = Math.min(hp[i + 1][j], hp[i][j + 1]) - dungeon[i][j];
				hp[i][j] = Math.max(hp[i][j], 1);
			}
		}

		return hp[0][0];
	}
	public static void main(String[] args) {
		int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		System.out.println(calculateMinimumHP(dungeon));
	}

}
