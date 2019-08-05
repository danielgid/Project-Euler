package euler_58;

public class Euler_58 {

	private Primes _primesUnder;

	public Euler_58() {
		long startTime = 0, EndTime = 0, totalTime = 0;

		startTime = System.currentTimeMillis();
		System.out.println("Start reading or genarating prime numbers.");

		_primesUnder = new Primes();

		EndTime = System.currentTimeMillis();
		totalTime = EndTime - startTime;
		System.out.println("End read or genarating prime numbers file.");
		System.out.println("Run time in miliseconds:\t" + (totalTime));
		System.out.println("Start sulotion");
		startTime = System.currentTimeMillis();

		runnerEuler(0.1);

		EndTime = System.currentTimeMillis();
		totalTime = EndTime - startTime;
		System.out.println("Run time in miliseconds:\t" + totalTime);
	}

	private void runnerEuler(double finallRatio) {
		double currRatio = 1.0;
		int totalCounter = 5, primeCounter = 3;
		int runner = 9, diff = 4;

		while (currRatio >= finallRatio) {
			for (int i = 0; i < 4; i++) {
				runner += diff;

				if (_primesUnder.isPrime(runner)) {
					primeCounter += 1;
				}
			}
			totalCounter += 4;

			currRatio = (double) primeCounter / (double) totalCounter;
			diff += 2;
		}

		diff -= 1;

		System.out.println("Answer for this problem :\t" + diff);
	}

}
