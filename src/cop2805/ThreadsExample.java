package cop2805;

class FibDynamic extends Thread implements Runnable {
	String name;

	public void run() {
		
		Long startTime = System.currentTimeMillis();
		int fibResult = fibonacci(40);
		Long EndTime = System.currentTimeMillis();
		
		Long totalTime = EndTime - startTime;
		System.out.printf(name + " Thread found the answer: " + fibResult + " in " + totalTime + "ms\n");
	}

	public FibDynamic(String name) {
		this.name = name;
	}

	private static int fibonacci(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		int prev1 = 1, prev2 = 1;
		for (int i = 2; i < n; i++) {
			int curr = prev1 + prev2;
			prev1 = prev2;
			prev2 = curr;
		}
		return prev2;
	}
}

class FibRecursion extends Thread implements Runnable {
	String name;

	public void run() {
		
		Long startTime = System.currentTimeMillis();
		int fibResult = fibonacci(40);
		Long EndTime = System.currentTimeMillis();
		
		Long totalTime = EndTime - startTime;
		System.out.printf(name + " Thread found the answer: " + fibResult + " in " + totalTime + "ms\n");
	}

	public FibRecursion(String name) {
		this.name = name;
	}

	private static int fibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}

public class ThreadsExample {

	public static void main(String[] args) {
		Thread t1 = new Thread(new FibDynamic("Dynamic"));
		Thread t2 = new Thread(new FibRecursion("Recursion"));

		t1.start();
		t2.start();
	}
}
