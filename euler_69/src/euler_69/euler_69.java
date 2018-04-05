package euler_69;

// TODO : how project work

public class euler_69 {

	public static int size;
	public static int[] primes;
	public static boolean[] nums;

	public static void main(String[] args) {
		euler69();
	}

	public static void init() {
		size = 0;
		primes = new int[78499];
		nums = new boolean[1000000];
	}

	public static void euler69() {
		init();
		double max = 0, tmp = 0;
		int max_value = 0;
		for (int i = 2; i < 1000000; i++) {
			if (if_prime(i)) {
				nums[i] = true;
				primes[size++] = i;
			} else {
				tmp = i / totient(i);
				if (tmp > max) {
					max = tmp;
					max_value = i;
				}
			}
		}
		System.out.println(max_value);
	}

	public static double totient(int num) {
		double rc = (double) num;
		for (int i = 0; primes[i] < num / 2; i++) {
			if (num % primes[i] == 0) {
				rc *= (1.0 - (1.0 / (double) primes[i]));
			}
		}
		
		return  rc;
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

}
