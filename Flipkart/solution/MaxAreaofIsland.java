package solution;

public class MaxAreaofIsland {
private static int n, m;
	
	public static int maxAreaOfIsland(int[][] grid) {
		int ans = 0;
		n = grid.length;
		m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] > 0) {
					ans = Math.max(ans, trav(i, j, grid));
				}
			}
		}
		return ans;
	}

	private static int trav(int i, int j, int[][] grid) {
		if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] < 1) {
			return 0;
		}
		grid[i][j] = 0;
		return 1 + trav(i - 1, j, grid) + trav(i, j - 1, grid) + trav(i + 1, j, grid) + trav(i, j + 1, grid);
	}

	public static void main(String[] args) {
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,0,1,1,1,0,0,0},
		{0,1,1,0,1,0,0,0,0,0,0,0,0},
		{0,1,0,0,1,1,0,0,1,0,1,0,0},
		{0,1,0,0,1,1,0,0,1,1,1,0,0},
		{0,0,0,0,0,0,0,0,0,0,1,0,0},
		{0,0,0,0,0,0,0,1,1,1,0,0,0},
		{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		System.out.println(maxAreaOfIsland(grid));
	}
	


}
