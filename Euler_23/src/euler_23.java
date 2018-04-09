public class euler_23 {

	public static boolean[] if_abundants_nums = new boolean[28124];
	public static int[] abundants_nums;

	public static void main(String[] args) {
		abundant_checker();
		all_nums_sums_check();
	}

	public static void all_nums_sums_check() {
		int counter = 0;

		for (int i = 0; i < 28124; i++) {
			if (!check_if_num_is_sum(i))
				counter += i;
		}
		System.out.println(counter);
	}

	public static boolean check_if_num_is_sum(int num) {
		int i = 0;

		while (abundants_nums[i] * 2 <= num) {
			if (if_abundants_nums[num - abundants_nums[i]])
				return true;
			i++;
		}
		return false;
	}

	public static void abundant_checker() {
		int size = 0;

		for (int i = 0; i < 28124; i++) {
			if (if_abundant(i)) {
				size++;
				if_abundants_nums[i] = true;
			}
		}

		marge_arrs(size);
	}

	public static void marge_arrs(int size) {
		int index = 0;
		abundants_nums = new int[size];

		for (int i = 0; i < 28124; i++) {
			if (if_abundants_nums[i]) {
				abundants_nums[index++] = i;
			}
		}
	}

	public static boolean if_abundant(int num) {
		int counter = 1, i;

		if (num < 12)
			return false;

		for (i = 2; i < ((num / 2) + 1); i++) {
			if (num % i == 0) {
				counter += i;
				if (counter > num)
					return true;
			}
		}

		return false;
	}
}
