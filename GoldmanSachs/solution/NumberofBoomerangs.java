package solution;

import java.util.HashMap;
import java.util.Map;

public class NumberofBoomerangs {

	public static int numberOfBoomerangs(int[][] points) {
		int ans = 0;
		for (int[] p : points) {
			Map<Integer, Integer> distCount = new HashMap<>();
			for (int[] q : points) {
				final int dist = (int) distance(p, q);
				distCount.put(dist, distCount.getOrDefault(dist, 0) + 1);
			}
			for (final int freq : distCount.values())
				ans += freq * (freq - 1);
		}
		return ans;
	}

	public static int distance(int[] a, int[] b) {
		return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
	}
	
	public static void main(String[] args) {
		int [][]points = {{0,0},{1,0},{2,0}};
		System.out.println(numberOfBoomerangs(points));
		
	}

}
