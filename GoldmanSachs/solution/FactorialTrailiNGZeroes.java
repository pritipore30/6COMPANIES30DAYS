package solution;

public class FactorialTrailiNGZeroes {
	public static int trailingZeroes(int n) {
		int count = 0;
		for (int i = 5; n / i >= 1; i *= 5) {
			int temp = n / i;
			count += temp;
		}
		return count;
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(trailingZeroes(n));
	}

}
