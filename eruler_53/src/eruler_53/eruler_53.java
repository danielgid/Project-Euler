package eruler_53;

public class eruler_53 {

	public static void main(String[] args) {
		System.out.println(count_combi(100));
	}

	public static int count_combi(int size) {
		int counter = 0;

		for (int n = 1; n <= size; n++) {
			for (int r = 1; r < n; r++) {
				if (if_more_million(n, r))
					counter++;
			}
		}

		return counter;
	}

	public static boolean if_more_million(int n, int r) {
		double result = 0;

		result = ((factorial(n)) / (factorial(n - r) * factorial(r)));

		if (result < 1000000)
			return false;
		return true;
	}

	public static double factorial(int n) {
		double result = 1;
		if (n < 0)
			return -1;

		for (int i = 1; i <= n; i++)
			result *= (double) i;

		return result;
	}

}
