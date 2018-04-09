package euler_92;

public class eruler_92 {

	// TODO : after check 10 million numbers adding all numbers
	// TODO : if number bigger than 10 million so only return the value

	// 0 - not checked, 1 - 1 result, 2 - 89 result

	private static int chains_result[];

	private static final int max_size = 100000000;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		euler92();

		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime + "ms");
	}

	private static void euler92() {
		init();
		int counter = 0;

		for (int i = 1; i < max_size/10; i++) {
			if (chains_result[i] == 0) {
				chains_result[i] = check_chain(i);
			}
		}

		for (int i = 1; i < max_size/10; i++) {
			if (chains_result[i] == 2) {
				counter++;
			}
		}
		System.out.println(counter);
	}

	private static void init() {
		chains_result = new int[max_size];

		for (int i = 0; i < max_size; i++) {
			chains_result[i] = 0;
		}

	}

	private static int square_digit(int num) {
		int rc = 0;

		while (num > 0) {
			rc += (int) Math.pow(num % 10.0, 2.0);
			num /= 10;
		}

		return rc;
	}

	private static int check_chain(int num) {
		if (num == 89)
			return 2;
		if (num == 1)
			return 1;

		if (num < max_size) {
			if (chains_result[num] != 0)
				return chains_result[num];
		}

		if (check_chain(square_digit(num)) == 1) {
			if (num < max_size)
				chains_result[num] = 1;
			return 1;
		}
		if (num < max_size)
			chains_result[num] = 2;
		return 2;
	}

}
