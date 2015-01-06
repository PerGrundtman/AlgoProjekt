package math;

import java.util.Random;
/**
 * Random-number generator
 * @author Per
 *
 */
public class RandomGen {
	Random rng;

	public RandomGen() {
		//	nextIntInRange(min, max, rng);
	}
	public int nextIntInRange(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException
			("Cannot draw random int from invalid range [" + min + ", " + max + "].");
		}
		int diff = max - min;
		if (diff >= 0 && diff != Integer.MAX_VALUE) {
			rng = new Random();
			return (min + this.rng.nextInt(diff + 1));
		}
		int i;
		do {
			i = this.rng.nextInt();
		} while (i < min || i > max);
		return i;
	}
}

