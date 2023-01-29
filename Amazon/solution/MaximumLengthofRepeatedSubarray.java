package solution;

public class MaximumLengthofRepeatedSubarray {
	public int findLength(int[] nums1, int[] nums2) {
		final int m = nums1.length;
		final int n = nums2.length;
		int ans = 0;
		int[] arr = new int[n + 1];

		for (int i = m - 1; i >= 0; --i)
			for (int j = 0; j < n; ++j) {
				arr[j] = nums1[i] == nums2[j] ? arr[j + 1] + 1 : 0;
				ans = Math.max(ans, arr[j]);
			}

		return ans;
	}
}
