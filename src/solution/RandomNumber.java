package solution;

import java.util.Random;

public class RandomNumber {

	public static Random random = new Random(System.nanoTime());
	
	public static int generateRandomNumber(int intervaloFinal) {
		// TODO Auto-generated method stub

		return random.nextInt(intervaloFinal) + 1;
	}
}
