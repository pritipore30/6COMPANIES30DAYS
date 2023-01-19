package solution;

import java.util.Arrays;

public class DistantBarcodes {
	public static int[] rearrangeBarcodes(int[] barcodes) {
		int[] ans = new int[barcodes.length];
		int[] count = new int[10001];
		int maxCount = 0;
		int maxNum = 0;

		for (final int b : barcodes)
			++count[b];

		for (int i = 1; i < 10001; ++i)
			if (count[i] > maxCount) {
				maxCount = count[i];
				maxNum = i;
			}

		fillAns(ans, count, maxNum, barcodes.length);
		for (int num = 1; num < 10001; ++num)
			fillAns(ans, count, num, barcodes.length);

		return ans;
	}

	private static int i = 0;

	private static void fillAns(int[] ans, int[] count, int num, int n) {
		while (count[num]-- > 0) {
			ans[i] = num;
			if (i + 2 < n) {
				i = i + 2;
			} else {
				i = 1;
			}
		}
	}

	public static void main(String[] args) {
		int[] barcodes = { 1, 1, 1, 2, 2, 2 };
		int[] result = rearrangeBarcodes(barcodes);
		System.out.println(Arrays.toString(result));
	}
}
