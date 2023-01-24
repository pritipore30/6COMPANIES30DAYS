package solution;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public static List<String> restoreIpAddresses(String s) {
		List<String> ans = new ArrayList<String>();
		restore(s, ans, 0, "", 0);
		return ans;
	}

	private static void restore(String curr, List<String> ans, int index, String temp, int count) {
		if (count > 4) {
			return;
		}
		if (count == 4 && index == curr.length()) {
			ans.add(temp);
		}
		for (int i = 1; i < 4; i++) {
			if (index + i > curr.length()) {
				break;
			}
			String s = curr.substring(index, index + i);
			if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) >= 256)) {
				continue;
			}
			restore(curr, ans, index + i, temp + s + (count == 3 ? "" : "."), count + 1);
		}
	}
	public static void main(String[] args) {
		String s = "25525511135";
		System.out.println(restoreIpAddresses(s));
	}

}
