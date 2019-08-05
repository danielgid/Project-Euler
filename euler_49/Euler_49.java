package euler_49;

public class Euler_49 {

	private Primes primesUnder10;
	private int[] primesNumbers;

	public Euler_49() {
		long startTime = 0, EndTime = 0, totalTime = 0;

		startTime = System.currentTimeMillis();
		System.out.println("Start reading or genarating prime numbers.");

		primesUnder10 = new Primes(100000);
		primesNumbers = primesUnder10.getPrimesArr();

		EndTime = System.currentTimeMillis();
		totalTime = EndTime - startTime;
		System.out.println("End read or genarating prime numbers file.");
		System.out.println("Run time in miliseconds:\t" + (totalTime));
		System.out.println("Start sulotion");
		startTime = System.currentTimeMillis();

		searchPrimes();

		EndTime = System.currentTimeMillis();
		totalTime = EndTime - startTime;
		System.out.println("Run time in miliseconds:\t" + totalTime);
	}

	private void searchPrimes() {
		int minIndex = findMinIndex(), maxIndex = findMamIndex();
		int high = 0, med = 0, low = 0, diff = 0;

		for (int i = minIndex; i < maxIndex; i++) {
			low = primesNumbers[i];
			for (int j = i + 1; j < maxIndex; j++) {
				med = primesNumbers[j];

				diff = med - low;
				high = med + diff;

				if (primesUnder10.isPrime(high)) {
					if (ifSamePerm(low, med, high))
						System.out.println(low + "\t" + med + "\t" + high);
				}
			}
		}
	}

	private int findMinIndex() {
		for (int i = 0; i < primesNumbers.length; i++) {
			if (primesNumbers[i] > 1000)
				return i;
		}

		return primesNumbers.length;
	}

	private int findMamIndex() {
		for (int i = 0; i < primesNumbers.length; i++) {
			if (primesNumbers[i] > 10000)
				return i;
		}

		return primesNumbers.length;
	}

	private boolean ifSamePerm(int low, int med, int high) {
		int[] digitsLow = counterDigits(low);
		int[] digitsMed = counterDigits(med);
		int[] digitsHigh = counterDigits(high);

		if (!ifEqualsCounter(digitsLow, digitsMed))
			return false;
		if (!ifEqualsCounter(digitsLow, digitsHigh))
			return false;

		return true;
	}

	private boolean ifEqualsCounter(int[] num1Digits, int[] num2Digits) {
		for (int i = 0; i < num2Digits.length; i++) {
			if (num1Digits[i] != num2Digits[i])
				return false;
		}

		return true;
	}

	private int[] counterDigits(int num) {
		int tmp;
		int[] counters = counterInit();

		tmp = num;

		while (tmp >= 1) {
			counters[tmp % 10]++;
			tmp /= 10;
		}

		return counters;
	}

	private int[] counterInit() {
		int[] counters = new int[10];

		for (int i = 0; i < counters.length; i++) {
			counters[i] = 0;
		}

		return counters;
	}

}
