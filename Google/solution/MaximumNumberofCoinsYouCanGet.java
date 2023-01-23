package solution;

import java.util.Arrays;

public class MaximumNumberofCoinsYouCanGet {
	public static int maxCoins(int[] piles) {
		Arrays.sort(piles);
		int res = 0, n = piles.length;
		for (int i = n / 3; i < n; i += 2)
			res += piles[i];
		return res;
	}

	public static void main(String[] args) {
		int[] arr = {2,4,1,2,7,8};
		System.out.println(maxCoins(arr));
	}
}
