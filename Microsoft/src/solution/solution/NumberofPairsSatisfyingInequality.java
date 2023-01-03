package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberofPairsSatisfyingInequality {
	static long ans = 0;
	public static long numberOfPairs(int[] nums1, int[] nums2, int diff) {
		int n = nums1.length;
		List<Integer> nums = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			 nums.add(nums1[i] - nums2[i]);
		}
		mergeSort(nums, 0, n-1, diff);
		return ans;
	}

	public static void mergeSort(List<Integer> nums, int left, int right, int diff) {
		if (left >= right)
			return;

		int mid = (left + right) / 2;
		mergeSort(nums, left, mid, diff);
		mergeSort(nums, mid + 1, right, diff);
		merge(nums, left, mid, right, diff);
	}

	public static void merge(List<Integer> nums, int left, int mid, int right, int diff) {
		int l = left;
		int r = mid +1;
		while(l <= mid && r <= right) {
			if(nums.get(l) <= (nums.get(r) + diff)) {
				ans +=(right - r+1);
				l++;
			}else {
				r++;
			}
		}
		List<Integer> sub = new ArrayList<>();
		for(int i = left; i < right+1; i++) {
			sub.add(nums.get(i));
		}
		Collections.sort(sub);
		for(int i = left; i< right +1; i++) {
			nums.set(i, sub.get(i-left));
		}

	}
	public static void main(String[] args) {
		int[] nums1 = {3,-1};
		int[] nums2 = {-2,2};
		int diff = -1;
		System.out.println(numberOfPairs(nums1,nums2,diff));
	}

}
