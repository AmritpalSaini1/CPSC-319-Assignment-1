/**
*This class is for running 3 different algorithms for computing the nth digit of the Fibonacci sequence.
* The 3 algorithms are given their own function.
* There is no main in this class.
*
* @author Amritpal Saini
* @version 1
* @class 1 
*
*/


public class Fibonacci {
	
	public static long[][] FM;
	
	/**
	 * Used to calculate the nth digit of the fibonacci sequence
	 * Recursively
	 * @param nMax nonnegative long
	 * @return nMax digit of the fibonacci sequence
	 */
	public static long recursion(long nMax) { 
		if (nMax == 0) {
			return 0;
		} else if (nMax == 1){
			return 1;
		} else {
			return recursion(nMax - 1) + recursion(nMax - 2);
		}
	}
	
	/**
	 * Used to calculate the nth digit of the fibonacci sequence
	 * Iteratively
	 * @param nMax nonnegative int
	 * @return nMax digit of the fibonacci sequence
	 */
	public static long loop(int nMax) { //O(n)
		long low = 0;
		long high = 1;
		long ans = 0;
		if (nMax == 0) {
			return 0;
		} else if (nMax == 1) {
			return 1;
		}else {
			for (int i = 0; i <= nMax - 2; i++) { // nMax - 2 because the first two cases are taken out
				ans = low + high;
				low = high;
				high = ans;
			}
		}
		return ans;
	}

	/**
	 * Used to calculate the nth digit of the fibonacci sequence
	 * using matrix powers
	 * @param nMax nonnegative int
	 * @return nMax digit of the fibonacci sequence
	 */
	public static long matrix(int nMax) {
		if (nMax == 0) {
			return 0;
		}
		Fibonacci.FM = new long[][] { {1,1}, 
									 {1,0} };
		MatrixPower(nMax - 1);
		return FM[0][0];
	}
	

	/**
	 * Used to calculate matrix multiplication for matrix function
	 * 
	 * @param n, given from matrix function from nMax
	 */
	private static void MatrixPower(int n) { //O(log(n)) base 2
		long TL;
		long TR;
		long BL;
		long BR;
		
		if (n > 1) {
			MatrixPower(n/2);
			TL = ((Fibonacci.FM[0][0] * Fibonacci.FM[0][0]) + (Fibonacci.FM[0][1] * Fibonacci.FM[1][0])); //good
			TR = ((Fibonacci.FM[0][0] * Fibonacci.FM[0][1]) + (Fibonacci.FM[0][1] * Fibonacci.FM[1][1])); //good
			BL = ((Fibonacci.FM[1][0] * Fibonacci.FM[0][0]) + (Fibonacci.FM[1][1] * Fibonacci.FM[1][0])); //good
			BR = ((Fibonacci.FM[1][0] * Fibonacci.FM[0][1]) + (Fibonacci.FM[1][1] * Fibonacci.FM[1][1])); //good
			
			Fibonacci.FM[0][0] = TL;
			Fibonacci.FM[0][1] = TR;
			Fibonacci.FM[1][0] = BL;
			Fibonacci.FM[1][1] = BR;
			
			if (n%2 != 0 ) {
				Fibonacci.FM[0][0] = (TL * 1) + (TR * 1); 
				Fibonacci.FM[0][1] = (TL * 1) + (BL * 0); 
				Fibonacci.FM[1][0] = (BL * 1) + (BR * 1); 
				Fibonacci.FM[1][1] = (BL * 1) + (BR * 0); 
			}
		}
	}
	
}

