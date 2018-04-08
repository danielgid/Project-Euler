public class euler_34 {

	public static void main(String[] args) {
		System.out.println(numbers_loop_checker());

	}

	public static double numbers_loop_checker() {
		double counter = 0, tmp;

		for (int i = 10; i < 2147483647; i++) {
			tmp = calculate_digit_factorial(i);
			if (tmp == 1) {
				counter += (double) i;
			} else if (tmp == -1) {
				i = i / 10;
				i = (i+1) * 10;
			}
		}
		return counter;
	}

	public static int calculate_digit_factorial(int num) {
		int counter = 0, tmp = num, tmp1;

		while (tmp != 0) {
			tmp1 = factorial(tmp % 10);
			if (tmp1 == -100000)
				return -1;
			else
				counter += tmp1;
			if (counter > num)
				return -1;
			tmp /= 10;
		}
		if (counter > num)
			return -1;
		if (counter == num)
			return 1;
		return 0;
	}

	public static int factorial(int num) {
		double tmp = 1;
		int rc = -1;

		for (int i = 1; i <= num; i++) {
			tmp *= i;
		}

		if (tmp > 2147483647)
			return -100000;

		rc = (int) tmp;
		return rc;
	}
}
