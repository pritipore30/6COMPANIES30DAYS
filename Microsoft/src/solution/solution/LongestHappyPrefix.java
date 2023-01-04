package solution;

public class LongestHappyPrefix {
	public static String longestPrefix(String s) {
		int n = s.length();
		if (n == 1) {
			return "";
		}
		int[] v = lps(s);
		int x = v[n - 1];
		String ret = "";
		for (int i = 0; i < x; i++) {
			ret += s.charAt(i);
		}
		return ret;
	}
	public static int[] lps(String s){
	      int n = s.length();
	      int[]ret = new int[n];
	      int j = 0;
	      int i = 1;
	      while (i < n) {
	         if (s.charAt(i) == s.charAt(j)) {
	            ret[i] = j + 1;
	            i++;
	            j++;
	         }
	         else if (s.charAt(i) != s.charAt(j)) {
	            if (j > 0)
	               j = ret[j - 1];
	            else {
	               i++;
	            }
	         }
	      }
	      return ret;
	   }
	
	public static void main(String[] args) {
		String s = "level";
		System.out.println(longestPrefix(s));
		
	}

}
