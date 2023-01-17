package solution;

public class FindtheWinneroftheCircularGame {
	public static int findTheWinner(int n, int k) {
		    boolean[] friends = new boolean[n];

		    int friendCount = n;
		    int fp = n;

		    while (friendCount > 1) {
		      for (int i = 0; i < k; ++i, ++fp) {
		        while (friends[fp % n]) {
		          ++fp;  
		        }
		      }
		      friends[(fp - 1) % n] = true;
		      --friendCount;
		    }

		    for (fp = 0; friends[fp]; ++fp)
		      ;
		    return fp + 1;
	}

	public static void main(String[] args) {
		int n = 5;
		int k = 2;
		System.out.println(findTheWinner(n,k));
	}

}
