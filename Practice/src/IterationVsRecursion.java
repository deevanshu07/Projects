public class IterationVsRecursion {

	public static int Factorial(int num) {
		int result = 1;
		if (num <= 1) {
			return result;
		}
		while (num > 1) {
			result *= num;
			num--;
		}
		return result;
	}

	public static int RecursionFactorial(int num) {
		if (num <= 1)
			return num;
		return num * RecursionFactorial(num - 1);
	}

	public static void main(String[] args) {

		long startTime1 = System.nanoTime();
		int factorial1=RecursionFactorial(100);
		long endTime1 = System.nanoTime();
		long timeTaken1 = endTime1 - startTime1;
		System.out.println("Recursion="+timeTaken1);
		
		long startTime = System.nanoTime();
		int factorial=Factorial(100);
		long endTime = System.nanoTime();
		long timeTaken = endTime - startTime;
		System.out.println("Iteration="+timeTaken);
		
	}
}
