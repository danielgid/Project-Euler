package euler_71;

public class euler_71 {
	public static double max;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		max = 3;
		max /= 7;

		System.out.println(order_fractions(8));

		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime + "ms");
	}

	public static long order_fractions(int resulution) {
		long counter = 0;
		double tmp, min = 0;
		for (int i = resulution; i > 1; i--) {
			for (int j = i; j >= 1; j--) {
				tmp = (double) j;
				tmp = tmp / i;
				if (tmp >= max || if_numbers_diff(j, i))
					continue;
				// counter++;
				if (tmp > min) {
					System.out.println(j + "\t" + i);
					min = tmp;
				}

			}
		}

		return counter;
	}

	public static boolean if_numbers_diff(int mone, int mahane) {
		if (mone == 1)
			return true;

		return mahane % mone == 0;
	}

}
