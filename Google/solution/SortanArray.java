package solution;

import java.util.Arrays;

public class SortanArray {
	public static int[] sortArray(int[] nums) {
		int[] result = sort(nums, 0, nums.length - 1);
		return result;
	}

	public static int[] merge(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		int i = 0;
		int j = 0;
		int k = 0;
		int n = a.length;
		int m = b.length;
		while (i < n && j < m) {
			if (a[i] < b[j]) {
				result[k++] = a[i++];
			} else {
				result[k++] = b[j++];
			}
		}

		while (i < n) {
			result[k++] = a[i++];
		}

		while (j < m) {
			result[k++] = b[j++];
		}

		return result;
	}

	public static int[] sort(int[] a, int left, int right) {
		if (left == right) {
			return new int[] { a[left] };
		}

		int middle = (left + right) / 2;
		int[] firstHalf = sort(a, left, middle);
		int[] secondHalf = sort(a, middle + 1, right);
		int[] sorted = merge(firstHalf, secondHalf);
		return sorted;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 1, 1, 2, 0, 0 };
		int[] result = sortArray(nums);
		System.out.println(Arrays.toString(result));
	}

}
