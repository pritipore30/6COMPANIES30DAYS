package solution;

import java.util.Arrays;

public class MaximumConsecutiveFloorsWithoutSpecialFloors {
	public static int maxConsecutive(int bottom, int top, int[] special) {
		int ans = 0;
		Arrays.sort(special);
		for (int i = 1; i < special.length; ++i) {
			ans = Math.max(ans, special[i] - special[i - 1] - 1);
		}

		return Math.max(ans, Math.max(special[0] - bottom, top - special[special.length - 1]));
	}

	public static void main(String[] args) {
		int bottom = 2;
		int top = 9;
		int[] special = {4, 6};
		System.out.println(maxConsecutive(bottom,top,special));

	}
}
