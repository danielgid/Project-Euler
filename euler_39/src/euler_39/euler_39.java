package euler_39;

public class euler_39 {

	public static void main(String[] args) {

		System.out.println(count_sol(1000));
	}

	public static int count_sol(int size) {
		int max = 0, tmp = 0,value=0;

		for (int i = 5; i <= size; i++) {
			tmp = count_i(i);
			if (tmp > max) {
				max = tmp;
				value=i;
			}
		}

		return value;
	}

	public static int count_i(int size) {
		int counter = 0, tmp = 0;

		for (int i = 1; i <= size / 2; i++) {
			for (int j = i; j + i < size; j++) {
				tmp = size - i - j;
				if (if_triangle((double) i, (double) j, (double) tmp, (double) size)) {
					counter++;
				}
			}
		}

		return counter;
	}

	public static boolean if_triangle(double a, double b, double c, double size) {
		if(c<b)
			return false;

		if (a + b + c != size)
			return false;

		if (a + b <= c || a + c <= b || b + c <= a)
			return false;

		if (Math.pow(a, 2) + Math.pow(b, 2) != Math.pow(c, 2))
			return false;

		if (Math.sqrt(Math.pow(a, 2)) != a)
			return false;
		if (Math.sqrt(Math.pow(b, 2)) != b)
			return false;
		if (Math.sqrt(Math.pow(c, 2)) != c)
			return false;

		return true;
	}

}
