package solution;

public class MagicalString {
	public static int magicalString(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n <= 3) {
			return 1;
		}
		StringBuilder sb = new StringBuilder("122");
		int i = 2;
		while (sb.length() < n) {
			int num = (sb.charAt(sb.length() - 1) - '0') ^ 3;
			int repeat = sb.charAt(i) - '0';
			for (int j = 0; j < repeat; j++) {
				sb.append(num);
			}
			i++;
		}
		int count = 0;
		for (i = 0; i < n; i++) {
			if (sb.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int n = 6;
		System.out.println(magicalString(n));
	}

}
