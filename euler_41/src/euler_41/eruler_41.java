package euler_41;

public class eruler_41 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		pandigital_prime();

		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime + "ms");
	}

	public static void pandigital_prime() {
		long num = 987654321l;

		while (num > 2143l) {
			if (legal_num(num)) {
				System.out.println(num);
				return;
			}
			num--;
		}
	}

	public static boolean legal_num(long num) {
		if (!if_pandigital(num))
			return false;
		return if_prime(num);
	}

	public static boolean if_prime(long num) {
		if (num <= 1)
			return false;
		else if (num == 2 || num == 3)
			return true;
		else if (num % 2 == 0)
			return false;
		else {
			for (long i = 3; i <= num / 2; i += 2)
				if (num % i == 0l) {
					return false;
				}
		}

		return true;
	}

	public static boolean if_pandigital(long num) {
		long tmp = num;
		int digit = 0, counter = 0, max = 0;
		long[] digits = new long[10];

		if (num < 9) {
			return true;
		} else {
			while (tmp >= 1) {
				digit = the_digit(tmp);
				digits[digit]++;
				if (digits[digit] > 1)
					return false;
				if (digit == 0)
					return false;
				if (digit > max)
					max = digit;
				tmp /= 10;
				counter++;
			}
		}
		if (max != counter)
			return false;
		return true;
	}

	public static int the_digit(long num) {
		long tmp = num;
		tmp /= 10l;
		tmp *= 10l;

		return (int) (num - tmp);
	}

}
