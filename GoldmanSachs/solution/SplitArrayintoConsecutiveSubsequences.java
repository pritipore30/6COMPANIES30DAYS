package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitArrayintoConsecutiveSubsequences {
	
	public static boolean isPossible(int[] nums) {
		Map<Integer, Integer> count = new HashMap<>();
		List<Integer> starts = new ArrayList<>(); 
		List<Integer> ends = new ArrayList<>();
		
		for (final int num : nums) {
			count.put(num, count.getOrDefault(num, 0) + 1);
		}
		
		for (int i = 0; i < nums.length; ++i) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			final int num = nums[i];
			final int currCount = count.get(num);
			final int prevCount = count.containsKey(num - 1) ? count.get(num - 1) : 0;
			final int nextCount = count.containsKey(num + 1) ? count.get(num + 1) : 0;
			
			for (int j = 0; j < currCount - prevCount; ++j) {
				starts.add(num);
			}
			
			for (int j = 0; j < currCount - nextCount; ++j) {
				ends.add(num);
			}
		}
		
		for (int i = 0; i < starts.size(); ++i) {
			if (ends.get(i) - starts.get(i) < 2) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3,3,4,5};
		System.out.println(isPossible(nums));
	}

}
