public class Euler_27 {

	private static int a_max;
	private static int b_max;
	private static int max_Length = 0;

	public static void main(String[] args) {
		System.out.println(quadric_primes());
	}

	private static int quadric_primes() {
		int a = -1000, b = -1000, counter = 0;
		a_max = -1000;
		b_max = -1000;

		for (; a <= 1000; a++) {
			for (b = -1000; b <= 1000; b++) {
				counter = 0;
				for (int i = 0; i < 1000; i++) {
					if (!calc_formula(i, a, b))
						break;
					counter++;
				}

				if (counter > max_Length) {
					a_max = a;
					b_max = b;
					max_Length = counter;
				}
			}
		}
		return a_max * b_max;
	}

	public static boolean calc_formula(int num, int a, int b) {
		double tmp = Math.abs(Math.pow((double) num, 2)
				+ (double) (a * num + b));
		if (if_prime((int) tmp))
			return true;

		return false;
	}

	public static boolean if_prime(int num) {
		if (num < 0)
			return false;

		if (num % 2 == 0)
			return false;

		for (int i = 3; i < num / 2; i += 2) {
			if (num % i == 0)
				return false;
		}

		return true;
	}

}
