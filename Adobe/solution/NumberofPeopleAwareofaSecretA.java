package solution;

public class NumberofPeopleAwareofaSecretA {
	public static int peopleAwareOfSecret(int n, int delay, int forget) {
		final int kMod = 1_000_000_007;
		long share = 0;
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; ++i) {
			if (i - delay >= 0) {
				share += dp[i - delay];
			}
			if (i - forget >= 0) {
				share -= dp[i - forget];
			}
			share += kMod;
			share %= kMod;
			dp[i] = (int) share;
		}
		int ans = 0;
		for (int i = n - forget; i < n; ++i) {
			ans = (ans + dp[i]) % kMod;
		}
		return ans;
	}
	public static void main(String[] args) {
		int n = 6;
		int delay = 2;
		int forget = 4;
		System.out.println(peopleAwareOfSecret(n, delay, forget));
	}

}
