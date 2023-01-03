package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostProfitablePath {
	public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
		final int n = amount.length;
		List<Integer>[] graph = new List[n];
		int[] parent = new int[n];
		int[] aDist = new int[n];
		Arrays.fill(aDist, -1);

		for (int i = 0; i < n; ++i)
			graph[i] = new ArrayList<>();

		for (int[] edge : edges) {
			final int u = edge[0];
			final int v = edge[1];
			graph[u].add(v);
			graph[v].add(u);
		}

		getParentDist(graph, 0, -1, 0, parent, aDist);
		for (int u = bob, bDist = 0; u != 0; u = parent[u], ++bDist)
			if (bDist < aDist[u])
				amount[u] = 0;
			else if (bDist == aDist[u])
				amount[u] /= 2;

		return getMoney(graph, 0, -1, amount);
	}

	public static void getParentDist(List<Integer>[] graph, int u, int prev, int d, int[] parent, int[] dist) {
		parent[u] = prev;
		dist[u] = d;
		for (final int v : graph[u]) {
			if (dist[v] == -1)
				getParentDist(graph, v, u, d + 1, parent, dist);
		}
	}

	public static int getMoney(List<Integer>[] graph, int u, int prev, int[] amount) {

		if (graph[u].size() == 1 && graph[u].get(0) == prev)
			return amount[u];

		int maxPath = Integer.MIN_VALUE;
		for (final int v : graph[u])
			if (v != prev)
				maxPath = Math.max(maxPath, getMoney(graph, v, u, amount));

		return amount[u] + maxPath;

	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 3, 4 } };
		int bob = 3;
		int[] amount = { -2, 4, 2, -4, 6 };
		System.out.println(mostProfitablePath(edges, bob, amount));
	}

}
