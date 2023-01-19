package solution;

public class New21Game {
	public static double new21Game(int n, int k, int maxPts) {
		if (k == 0 || n >= k - 1 + maxPts) {
			return 1.0;
		}

		double ans = 0.0;
		double[] probability = new double[n + 1];
		probability[0] = 1.0;
		double windowSum = probability[0];
		for (int i = 1; i <= n; ++i) {
			probability[i] = windowSum / maxPts;
			if (i < k) {
				windowSum += probability[i];
			} else {
				ans += probability[i];
			}
			if (i - maxPts >= 0) {
				windowSum -= probability[i - maxPts];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int n = 10;
		int k = 1;
		int maxPts = 10;
		System.out.println(new21Game(n, k, maxPts));
	}
}
