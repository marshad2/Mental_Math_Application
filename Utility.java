package ProjectCalc;
import java.util.Random;

class Utility {
	    public static Random rand = new Random();

	    public static int generateRandomNumber(int min, int max) {
	        return rand.nextInt((max - min) + 1) + min;
	    }
	}

