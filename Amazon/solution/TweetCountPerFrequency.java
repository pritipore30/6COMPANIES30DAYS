package solution;

public class TweetCountPerFrequency {
	HashMap<String, List<Integer>> hashMap;

	public TweetCountPerFrequency() {
        hashMap = new HashMap<>();
    }

	public void recordTweet(String tweetName, int time) {
		if (hashMap.containsKey(tweetName)) {
			List<Integer> list = hashMap.get(tweetName);
			list.add(time);
			hashMap.put(tweetName, list);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(time);
			hashMap.put(tweetName, list);
		}
	}

	public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {

		if (freq.equals("minute"))
			return getFreq(60, startTime, endTime, tweetName);

		if (freq.equals("hour"))
			return getFreq(3600, startTime, endTime, tweetName);

		if (freq.equals("day"))
			return getFreq(3600 * 24, startTime, endTime, tweetName);
		else
			return null;
	}

	public List<Integer> getFreq(int delta, int startTime, int endTime, String tweetName) {
		int length = (endTime - startTime) / delta + 1;
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < length; i++)
			ans.add(0);
		List<Integer> timestamps = hashMap.get(tweetName);
		for (int timestamp : timestamps) {
			if (timestamp >= startTime && timestamp <= endTime) {
				int index = (timestamp - startTime) / delta;
				ans.set(index, ans.get(index) + 1);
			}
		}
		return ans;
	}

}
