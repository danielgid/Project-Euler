package euler_32;

public class euler_32 {

	private static boolean pandigital[];

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		euler32();

		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime + "ms");
	}

	private static void euler32() {
		init();

		for (int i = 123456789; i <= 987654321; i++) {
			if (if_pandigital(i)) {
				if_pandigital_1_4(i / 10000, i % 10000);
				if_pandigital_2_3(i / 10000, i % 10000);
			}
		}
		sum();
	}

	private static void sum() {
		int sum = 0;

		for (int i = 0; i < pandigital.length; i++) {
			if (pandigital[i]) {
				sum += i;
			}
		}
		System.out.println("The sum of products : " + sum);
	}

	private static void init() {
		pandigital = new boolean[10000];
		for (int i = 0; i < pandigital.length; i++) {
			pandigital[i] = false;
		}
	}

	private static boolean if_pandigital(int num) {
		int tmp = num;
		int digit = 0, counter = 0;
		int[] digits = new int[10];

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
				tmp /= 10;
				counter++;
			}
		}
		if (9 != counter)
			return false;
		return true;
	}

	private static void if_pandigital_1_4(int num, int product) {
		int m1 = num % 10, m2 = num / 10;

		if (m1 * m2 == product) {
			update_products(m1, m2, product);
		}
	}

	private static void if_pandigital_2_3(int num, int product) {
		int m1 = num % 100, m2 = num / 100;

		if (m1 * m2 == product) {
			update_products(m1, m2, product);
		}
	}


	private static void update_products(int m1, int m2, int product) {
		if (m1 * m2 == product) {
			pandigital[product] = true;
		}
	}

	private static int the_digit(int num) {
		int tmp = num;
		tmp /= 10l;
		tmp *= 10l;

		return (int) (num - tmp);
	}

}
