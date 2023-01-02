package solution;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargestDivisibleSubset {
	public static List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<Integer>();
        }
        int[] dp = new int[nums.length];
        int[] index = new int[nums.length];
        dp[0] = 1;
        index[0] = -1;
        Arrays.sort(nums);
        int max = 0;
        int start = 0;
        for (int i = 1; i < nums.length; i ++) {
            index[i] = -1;
            dp[i] = 1;
            for (int j = 0; j < i; j ++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    index[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                start = i;
            }
        }
        int i = start;
        List<Integer> result = new LinkedList<Integer>();
        while (i != -1) {
            result.add(0, nums[i]);
            i = index[i];
        }
        return result;
    }
	public static void main(String[]args) {
		int[] nums = {1,2,4,8};
		List<Integer> result =largestDivisibleSubset(nums);
		System.out.println(result.toString());
	}

	
	
   

}
