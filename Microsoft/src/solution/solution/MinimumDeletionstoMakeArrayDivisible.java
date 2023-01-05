package solution;

import java.util.Arrays;

public class MinimumDeletionstoMakeArrayDivisible {
	public static int minOperations(int[] nums, int[] numsDivide) {
	    int gcd = getGCD(numsDivide);

	    Arrays.sort(nums);

	    for (int i = 0; i < nums.length; ++i)
	      if (gcd % nums[i] == 0) {
	        return i;
	      }

	    return -1;
	  }

	  public static int getGCD(int[] nums) {
	    int g = nums[0];
	    for (int i = 0; i < nums.length; i++)
	      g = gcd(g, nums[i]);
	    return g;
	  }

	  public static int gcd(int a, int b) {
	    if(b == 0) {
	    	return a;
	    }else {
	    	return gcd(b, a % b);
	    }
	  }
	  public static void main(String[] args) {
		 int[] nums = {4,3,6};
		 int[] numsDivide = {8,2,6,10};
		 System.out.println(minOperations(nums,numsDivide));
	  }

}
