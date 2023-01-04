package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NumberofWaystoArriveatDestination {
	public static int countPaths(int n, int[][] roads) {
		int[] dist = new int[n];
		int[] ways = new int[n];
		Map<Integer, List<int[]>> graph=new HashMap();
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            graph.put(i, new ArrayList());

        }
        for(int[] e: roads){
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> (a[1]- b[1]));
        pq.add(new int[]{0, 0});
        dist[0] = 0;
		ways[0] = 1;
		int mod = (int) (1e9 + 7);
		 while(!pq.isEmpty()){
             int[] top=pq.poll();
             int u=top[0], d=top[1];
             if(dist[u]< d)
                 continue;
             for(int[] v: graph.get(u)){
                 if(dist[v[0]] > d + v[1]){
                     dist[v[0]] = d+v[1];
                     ways[v[0]]=ways[u];
                     pq.offer(new int[]{v[0], dist[v[0]]});
                 }else{
                     if(dist[v[0]] == d+v[1]){
                         ways[v[0]]+=ways[u];
                         ways[v[0]]%= mod;
                     }
                 }
             }
         }
		return ways[n - 1] % mod;
	}
	public static void main(String[] args) {
		int n = 7;
		int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
		System.out.println(countPaths(n,roads));
	}

}
