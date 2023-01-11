package solution;

import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {
	public static String fractionToDecimal(int numerator, int denominator) {
		StringBuilder result = new StringBuilder();
		if (numerator == 0) {
			return "0";
		}
		if (numerator < 0 ^ denominator < 0) {
			result.append("-");
		}
		long n = Math.abs((long) numerator);
		long d = Math.abs((long) denominator);
		result.append(n / d);
		if (n % d == 0) {
			return result.toString();
		}
		result.append(".");
		Map<Long, Integer> map = new HashMap<>();
		for (long r = n % d; r > 0; r %= d) {
			if (map.containsKey(r)) {
				result.insert(map.get(r), "(");
				result.append(")");
				break;
			}
			map.put(r, result.length());
			r *= 10;
			result.append(r / d);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		int numerator = 1; 
		int denominator = 2;
		System.out.println(fractionToDecimal(numerator,denominator));

	}

	

}
