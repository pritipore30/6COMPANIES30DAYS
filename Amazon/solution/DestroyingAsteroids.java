package solution;

public class DestroyingAsteroids {
	public boolean asteroidsDestroyed(int mass, int[] asteroids) {
		Arrays.sort(asteroids);

		long m = mass;

		for (final int asteroid : asteroids)
			if (m >= asteroid)
				m += asteroid;
			else
				return false;

		return true;
	}
}
