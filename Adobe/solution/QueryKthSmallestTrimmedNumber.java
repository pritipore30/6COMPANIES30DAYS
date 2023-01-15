package solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class QueryKthSmallestTrimmedNumber {
	public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
		int n = queries.length;
		int j = 0;
		int[] ans = new int[n];
		Map<Integer, String[][]> trimmed = new HashMap<>();
		for (int[] q : queries) {
			int k = q[0] - 1;
			int trim = q[1];
			if (!trimmed.containsKey(trim)) {
				String[][] arr = new String[nums.length][2];
				int i = 0;
				for (String num : nums) {
					int sz = num.length();
					arr[i] = new String[] { num.substring(sz - trim), "" + i++ };
				}
				Arrays.sort(arr, Comparator.comparing(a -> a[0]));
				trimmed.put(trim, arr);
			}
			ans[j++] = Integer.parseInt(trimmed.get(trim)[k][1]);
		}
		return ans;
	}
	public static void main(String[] args) {
		String[] nums = {"102","473","251","814"};
		int[][] queries = {{1,1},{2,3},{4,2},{1,2}};
		int[] result = smallestTrimmedNumbers(nums,queries);
		System.out.println(Arrays.toString(result));
		
	}

}
