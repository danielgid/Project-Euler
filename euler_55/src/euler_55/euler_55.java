package euler_55;

public class euler_55 {

	public static void main(String[] args) {
		euler55();
	}

	public static void euler55() {
		int counter = 0;
		for (int i = 10; i < 10000; i++) {
			if(i==196)
				System.out.println("");
			if (lychrel_num((long) i)) {
				counter++;
			}

		}
		System.out.println(counter);
	}

	public static boolean lychrel_num(long num) {
		long reverse = 0;
		for (int i = 0; i < 25; i++) {
			reverse = revers_num(num);
			num += reverse;
			if (if_polindrome(num))
				return false;
		}

		return true;
	}

	public static boolean if_polindrome(long num) {
		long revers_num = revers_num(num);
		if (num < 10)
			return true;
		if (revers_num != num)
			return false;
		return true;
	}

	public static long revers_num(long num) {
		long revers_num = 0, pow = 10;

		while (num >= 1) {
			revers_num = (pow * revers_num + (num % 10));
			num /= 10;
			//pow *= 10;
		}

		return revers_num;
	}

}
