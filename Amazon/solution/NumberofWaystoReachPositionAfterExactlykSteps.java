package solution;

public class NumberofWaystoReachPositionAfterExactlykSteps {
	public int numberOfWays(int startPos, int endPos, int k) {
		final int value = k + endPos - startPos;
		if (value < 0 || value % 2 == 1)
			return 0;
		final int rightStep = value / 2;
		final int leftStep = k - rightStep;
		if (leftStep < 0)
			return 0;
		return nChooseK(leftStep + rightStep, Math.min(leftStep, rightStep));
	}
	private int nChooseK(int n, int k) {
		final int kMod = 1_000_000_007;
		int[] result = new int[k + 1];
		result[0] = 1;

		while (n-- > 0) 
			for (int j = k; j > 0; --j) {
				result[j] += result[j - 1];
				result[j] %= kMod;
			}

		return result[k];
	}
}
