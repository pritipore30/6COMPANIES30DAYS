package solution;

public class NonnegativeIntegerswithoutConsecutiveOnes {
	public static int findIntegers(int n) {
		StringBuilder bits = new StringBuilder();
		for (; n > 0; n >>= 1) {
			bits.append(n & 1);
		}
		final int len = bits.length();
		int[] zero = new int[len];
		int[] one = new int[len];
		zero[0] = 1;
		one[0] = 1;
		for (int i = 1; i < len; ++i) {
			zero[i] = zero[i - 1] + one[i - 1];
			one[i] = zero[i - 1];
		}
		int ans = zero[len - 1] + one[len - 1];
		for (int i = len - 2; i >= 0; --i) {
			if (bits.charAt(i) == '1' && bits.charAt(i + 1) == '1') {
				break;
			}
			if (bits.charAt(i) == '0' && bits.charAt(i + 1) == '0') {
				ans -= one[i];
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int n = 5;
		System.out.println(findIntegers(n));
		
	}

}
