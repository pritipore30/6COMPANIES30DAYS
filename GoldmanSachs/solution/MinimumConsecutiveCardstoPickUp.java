package solution;

import java.util.HashMap;
import java.util.Map;

public class MinimumConsecutiveCardstoPickUp {
	
	public static int minimumCardPickup(int[] cards) {
		int min = Integer.MAX_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < cards.length; i++) {
			if (map.containsKey(cards[i])) {
				min = Math.min(min, i - map.get(cards[i]) + 1);
			}
			map.put(cards[i], i);
		}
		if (min == Integer.MAX_VALUE) {
			return -1;
		} else {
			return min;
		}
	}
	public static void main(String[] args){
		int[] cards = {3,4,2,3,4,7};
		System.out.println(minimumCardPickup(cards));
	}

}
