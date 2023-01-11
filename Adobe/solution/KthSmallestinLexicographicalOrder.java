package solution;

public class KthSmallestinLexicographicalOrder {
	public static int findKthNumber(int n, int k) {
		long curr = 1;
		for (int i = 1; i < k;) {
			long gap = getGap(curr, curr + 1, n);
			if (i + gap <= k) {
				i += gap;
				++curr;
			} else {
				i++;
				curr *= 10;
			}
		}
		return (int) curr;
	}

	private static long getGap(long a, long b, long n) {
		long gap = 0;
		while (a <= n) {
			gap += Math.min(n + 1, b) - a;
			a *= 10;
			b *= 10;
		}
		return gap;
	}

	public static void main(String[] args) {
		int n = 13; 
		int k = 2;
		System.out.println(findKthNumber(n,k));
	}
}
