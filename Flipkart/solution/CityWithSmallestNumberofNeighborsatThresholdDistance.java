package solution;

import java.util.Arrays;

public class CityWithSmallestNumberofNeighborsatThresholdDistance {
	public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = (int) 1e6;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int[] edge : edges) {
            int v1 = edge[0], v2 = edge[1], w = edge[2];
            dist[v1][v2] = dist[v2][v1] = w;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int minReachable = n;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int reachable = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    reachable++;
                }
            }
            if (reachable <= minReachable) {
                minReachable = reachable;
                ans = i;
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		int n = 4;
		int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
		int distanceThreshold = 4;
		System.out.println(findTheCity(n,edges,distanceThreshold));
	}
}
