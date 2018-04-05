package euler_35;

public class euler_35 {
	public static int[] primes;
	public static int size = 1000000;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		init();
		print(size);

		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime + "ms");
	}

	public static void init() {
		primes = new int[size];
		for (int i = 0; i < primes.length; i++) {
			primes[i] = -2;
		}
	}

	public static void print(int size) {
		int counter = 0;
		for (int i = 1; i < size; i++) {
			if (primes[i] == -2) {
				check_num(i);
			}
		}

		for (int i = 1; i < size; i++) {
			if (primes[i] == 1) {
				counter++;
			}
		}
		System.out.println("the num of primes: " + counter);
	}

	public static void check_num(int num) {
		if_have_even_digit(num);
		if (primes[num] == 0)
			if_prime(num);

		if (primes[num] == 0) {
			if (check_prime(num))
				primes[num] = 1;
		}

	}

	public static void if_prime(int num) {
		if (num <= 1)
			primes[num] = -1;
		else if (num == 2 || num == 3)
			primes[num] = 0;
		else if (num % 2 == 0)
			primes[num] = -1;
		else {
			for (int i = 3; i <= num / 2; i += 2)
				if (num % i == 0) {
					primes[num] = -1;
					return;
				}

			primes[num] = 0;
		}
	}

	public static void if_have_even_digit(int num) {
		int tmp = 0, tmp_num = num;
		if (num < 9) {
			if_prime(num);
			if (primes[num] == 0)
				primes[num] = 1;
			return;
		} else {
			primes[num] = 0;
			while (tmp_num > 1) {
				tmp = tmp_num % 10;
				if (tmp % 2 == 0 || tmp == 5 || tmp == 0)
					primes[num] = -1;
				tmp_num /= 10;
			}
		}

	}

	public static boolean check_prime(int num) {
		int pow = 0;

		while (num > (int) Math.pow((double) 10, (double) pow)) {
			pow += 1;
		}
		return all_options(num, pow - 1, pow);
	}

	public static boolean all_options(int num, int pow, int i) {
		int tmp;
		boolean rc;

		tmp = num % 10;
		tmp *= (int) Math.pow((double) 10, (double) pow);
		num /= 10;
		num += tmp;
		if_prime(num);

		if (primes[num] != 0) {
			primes[num] = -1;
			return false;
		}

		if (i == 0) {
			if (primes[num] == 0)
				primes[num] = 1;
			return true;
		}

		rc = all_options(num, pow, --i);
		if (rc)
			primes[num] = 1;
		return rc;
	}

}
