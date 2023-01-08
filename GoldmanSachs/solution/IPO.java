package solution;

import java.util.PriorityQueue;

public class IPO {
	public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
		int n = capital.length;
		PriorityQueue<int[]> q1 = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		for (int i = 0; i < n; ++i) {
			q1.offer(new int[] { capital[i], profits[i] });
		}
		PriorityQueue<Integer> q2 = new PriorityQueue<>((a, b) -> b - a);
		while (k-- > 0) {
			while (!q1.isEmpty() && q1.peek()[0] <= w) {
				q2.offer(q1.poll()[1]);
			}
			if (q2.isEmpty()) {
				break;
			}
			w += q2.poll();
		}
		return w;
	}

	public static void main(String[] args) {
		int k = 2;
		int w = 0;
		int[] profits = {1,2,3};
		int[] capital = {0,1,1};
		System.out.println(findMaximizedCapital(k,w,profits,capital));
	}

}
