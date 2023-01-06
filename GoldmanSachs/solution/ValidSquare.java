package solution;

import java.util.HashSet;
import java.util.Set;

public class Validsquare {
	public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		Set<Integer> dist = new HashSet<>();
		dist.add(distance(p1, p2));
		dist.add(distance(p1, p3));
		dist.add(distance(p1, p4));
		dist.add(distance(p2, p3));
		dist.add(distance(p2, p4));
		dist.add(distance(p3, p4));
		return !dist.contains(0) && dist.size() == 2;

	}

	public static int distance(int[] a, int[] b) {
		return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
	}

	public static void main(String[] args) {
		int[] p1 = { 0, 0 };
		int[] p2 = { 1, 1 };
		int[] p3 = { 1, 0 };
		int[] p4 = { 0, 1 };
		boolean result = validSquare(p1, p2, p3, p4);
		System.out.println(result);
	}

}
