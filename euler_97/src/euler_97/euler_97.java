package euler_97;

public class euler_97 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		euler_97();
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime + "ms");
	}

	public static void euler_97() {
		int[] last_digits = two_power(10, 7830457);
		last_digits[0] += 1;
		print(last_digits);
	}

	public static int[] two_power(int size, int loops) {
		int tmp = 0, carry = 0;
		int[] last_digits = init(size, 28433);

		for (int i = 0; i < loops; i++) {
			carry = 0;
			for (int j = 0; j < last_digits.length; j++) {
				tmp = last_digits[j];
				tmp = tmp * 2 + carry;

				if (tmp >= 10) {
					tmp = tmp % 10;
					carry = 1;
				} else {
					carry = 0;
				}

				last_digits[j] = tmp;
			}

		}
		return last_digits;
	}

	public static int[] init(int size, int start_num) {
		int[] last_digits = new int[size];
		for (int i = 0; i < size; i++) {
			last_digits[i] = start_num % 10;
			start_num /= 10;
		}

		return last_digits;
	}

	public static void print(int[] last_digits) {
		for (int i = 0; i < last_digits.length; i++) {
			System.out.print(last_digits[9 - i]);
		}

		System.out.println();
	}

}
