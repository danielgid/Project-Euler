public class Euler_24 {

	public final static class p024 {
		public static int[] a;
		public static int[] digits;

		public static void main(String[] args) {
			the_permition();
		}

		public static void the_permition() {
			a = new int[10];
			digits = new int[10];
			for (int i = 0; i < a.length; i++) {
				a[i] = i;
				digits[i] = i;
			}

			premutation(1000000, 10);

			String ans = "";

			for (int i = 0; i < a.length; i++) {
				ans += a[i];
			}

			System.out.print(ans);
		}

		public static void premutation(int num, int index) {
			int tmp = 0;
			int[] array = new int[10];

			for (int i = 0; i < a.length - 3; i++) {
				tmp = num / factorial(a.length - i - 1);
				num -= factorial(a.length - i - 1) * tmp;
				array[i] = next_digit(tmp);
			}

			a = array;

			last_3(num);
		}

		public static int nextFactorial(int num, int index) {
			int i;
			for (i = 0; i < index; i++) {
				if (factorial(index) * i > num)
					break;
			}

			return i - 1;
		}

		static int factorial(int n) {
			if (n == 0)
				return 1;
			else
				return (n * factorial(n - 1));
		}

		public static int next_digit(int index) {
			int digit = digits[index];

			int[] new_digits = new int[digits.length - 1];
			int j = 0;

			for (int i = 0; i < digits.length; i++) {
				if (index != i) {
					new_digits[j++] = digits[i];
				}
			}
			digits = new int[new_digits.length];
			for (int i = 0; i < new_digits.length; i++) {
				digits[i] = new_digits[i];
			}

			return digit;
		}

		public static void last_3(int num) {
			if (digits.length > 2) {
				if (num > 4) {
					a[a.length - 3] = digits[2];
					next_digit(2);
				} else if (num > 2) {
					a[a.length - 3] = digits[1];
					next_digit(1);
				} else {
					a[a.length - 3] = digits[0];
					next_digit(0);
				}
				last_2(num / 2);
			} else {
				last_2(num);
			}
		}

		public static void last_2(int num) {
			if (num == 1) {
				a[a.length - 2] = digits[0];
				a[a.length - 1] = digits[1];
			} else {
				a[a.length - 2] = digits[1];
				a[a.length - 1] = digits[0];
			}
		}

	}
}
