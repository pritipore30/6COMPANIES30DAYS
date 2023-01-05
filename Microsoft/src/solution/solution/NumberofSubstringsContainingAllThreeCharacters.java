package solution;

public class NumberofSubstringsContainingAllThreeCharacters {
	public static int numberOfSubstrings(String s) {
		int arr[] = {0, 0, 0};
	       int count = 0;
	       int i = 0;
	       int n = s.length();
	        for (int j = 0; j < n; ++j) {
	            ++arr[s.charAt(j) - 'a'];
	            while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0)
	                --arr[s.charAt(i++) - 'a'];
	            count += i;
	        }
	        return count;
	}

	public static void main(String[] args) {
		String s = "abcabc";
		System.out.println(numberOfSubstrings(s));

	}

}
