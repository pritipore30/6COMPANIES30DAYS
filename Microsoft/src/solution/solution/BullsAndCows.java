package solution;

public class BullsAndCows {
	public static String getHint(String secret, String guess) {
		int bull = 0;
		int cow = 0;
		int[] nums = new int[10];
		for(int i = 0; i < secret.length(); i++) {
			int s = Integer.parseInt(String.valueOf(secret.charAt(i)));
			int g = Integer.parseInt(String.valueOf(guess.charAt(i)));
			if(s == g) {
				bull ++;
			}else {
				if(nums[s] < 0) {
					cow++;
				}
				if(nums[g] > 0) {
					cow++;
				}
				nums[s]++;
				nums[g]--;
			}
		}
		return bull+"A"+cow+"B";

	}
	public static void main(String[] args) {
		String secret = "1807";
		String guess = "7810";
		System.out.println(getHint(secret,guess));
	}

}
