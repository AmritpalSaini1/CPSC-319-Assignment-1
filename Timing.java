/**
 * This class is used to find the time, in nanoseconds, to compute some digit of the fibonacci sequence
 * 
 * @Alg1 Recursive
 * @Alg2 Iterative
 * @Alg3 Matrix power
 * 
 * @author Amritpal Saini, 30039983
 * @version 1
 * @class 2, (main)
 *
 */


public class Timing {
	
	/**
	 * Main function, used to run all the timers for the algorithms
	 * @param args
	 */
	
	public static void main(String[] args) {
		System.out.println("Time to calculate in NanoSeconds");
		System.out.println(" ");
		Rtiming(40);
		System.out.println(" ");
		Ltiming(40);
		System.out.println(" ");
		Mtiming(40);
	}
	
	/**
	 * Function is used to print the time required to calculate all digits
	 * of the fibonacci sequence from 0 to the int given in a recursive manner.
	 * @param fib nonnegative int
	 */
	
	public static void Rtiming(int fib) {
		double startTime;
		for (int i = 0; i <= fib; i++) {
			startTime = System.nanoTime();
			Fibonacci.recursion(i);
			double endTime = System.nanoTime();
			double time = endTime - startTime;
			System.out.println(time + " Time to compute F" + i + "  with Alg. 1");	
		}
	}
	
	/**
	 * Function is used to print the time required to calculate all digits
	 * of the fibonacci sequence from 0 to the int given in an iterative manner.
	 * @param fib nonnegative int
	 */
	
	public static void Ltiming(int fib) {
		double startTime;
		for (int i = 0; i <= fib; i++) {
			startTime = System.nanoTime();
			for(int j = 0; j <= 1000; j++) {
				Fibonacci.loop(i);
			}
			double endTime = System.nanoTime();
			double time = (endTime - startTime)/1000;
			System.out.println(time + " Time to compute F" + i + "  with Alg. 2");	
		}
	}
	
	/**
	 * Function is used to print the time required to calculate all digits
	 * of the fibonacci sequence from 0 to the int given in a matrix power manner.
	 * @param fib nonnegative int
	 */

	public static void Mtiming(int fib) {
		double startTime;
		for (int i = 0; i <= fib; i++) {
			startTime = System.nanoTime();
			for(int j = 0; j <= 1000; j++) {
				Fibonacci.matrix(i);
			}
			double endTime = System.nanoTime();
			double time = (endTime - startTime)/1000;
			System.out.println(time + " Time to compute F" + i + "  with Alg. 3");
		}
	}

}