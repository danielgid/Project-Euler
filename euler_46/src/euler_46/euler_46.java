package euler_46;

public class euler_46 {

	public static int size = 10000;
	public static int[] squares;
	public static boolean[] primes;

	public static void main(String[] args) {
		euler46();
	}

	public static void euler46() {
		init();

		for (int i = 3; i < size; i += 2) {

			if (!primes[i] && !goldbachs(i))
				System.out.println(i + "\t is not goldbachs");
		}
	}

	public static boolean goldbachs(int num) {
		int i = 1, tmp = 0;

		for (; i < size && (i * i * 2) < num; i++) {
			tmp = num - (i * i * 2);

			if (primes[tmp] == true)
				return true;
		}

		return false;
	}

	public static void init() {
		primes = new boolean[size];

		check_primes();
	}

	public static void check_primes() {
		for (int i = 0; i < primes.length; i++) {
			primes[i] = if_prime(i);
		}
	}

	public static boolean if_prime(int num) {
		if (num <= 0)
			return false;
		if (num < 4)
			return true;
		if (num % 2 == 0)
			return false;

		for (int i = 3; i < num / 2; i++)
			if (num % i == 0)
				return false;

		return true;
	}

	public static void fill_squares() {
		for (int i = 0; i < squares.length; i++) {
			squares[i] = 2 * i * i;
		}
	}

}
