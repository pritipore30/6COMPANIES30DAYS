package solution;

public class ShortestUnsortedContinuousSubarrayA {
	public static int findUnsortedSubarray(int[] nums) {
		int n = nums.length;
		int max = nums[0];
		int end = -1;
		for (int i = 0; i < n; i++) {
			if (max > nums[i]) {
				end = i;
			} else {
				max = nums[i];
			}
		}
		int min = nums[n - 1];
		int start = 0;
		for (int i = n - 2; i >= 0; i--) {
			if (min < nums[i]) {
				start = i;
			} else {
				min = nums[i];
			}
		}
		return end - start + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
		System.out.println(findUnsortedSubarray(nums));

	}

}
