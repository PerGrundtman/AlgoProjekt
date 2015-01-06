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
		
	}
	public double nextDoubleInRange(double min, double max) {
		if (min > max) {
			throw new IllegalArgumentException
			("Cannot draw random Double from an invalid range [" + min + ", " + max + "]. mmkay?");
		}
		double diff = max - min;
		if (diff >= 0 && diff != Double.MAX_VALUE) {
			this.rng = new Random();
			double random = this.rng.nextDouble();
			double result = min + (random * (max - min));
			return result;
			
		}
		int i;
		do {
			i = this.rng.nextInt();
		} while (i < min || i > max);
		return i;
	}
}

