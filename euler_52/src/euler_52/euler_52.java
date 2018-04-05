package euler_52;

public class euler_52 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(numbers_cheker());
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime + "ms");
	}

	public static int numbers_cheker() {
		int j;
		for (int i = 1; i < Integer.MAX_VALUE/6; i++) {
			for ( j = 2; j < 7; j++) {
				if(!digits_compare(i, i*j))break;
			}
			if(j==7) {
				return i;
				//System.out.println(i);
			}
		}
		return 0;
	}

	public static boolean digits_compare(int a, int b) {
		int[] a_digits, b_digits;

		a_digits = digits_counter(a);
		b_digits = digits_counter(b);

		for (int i = 0; i < b_digits.length; i++) {
			if (a_digits[i] != b_digits[i])
				return false;
		}

		return true;
	}

	public static int[] digits_counter(int num) {
		int[] digits = new int[10];

		for (int i = 0; i < digits.length; i++) {
			digits[i] = 0;
		}

		for (int i = 0; i < digits.length; i++) {
			digits[num % 10] += 1;
			num /= 10;
		}

		return digits;
	}

}
