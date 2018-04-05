package euler_73;

public class euler_73 {
	public static float max;
	public static float min;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		min =((float)1 /(float) 3);
		max = ((float)1 /(float) 2);
		System.out.println(order_fractions(12000));

		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime + "ms");
	}

	public static long order_fractions(int resulution) {
		long counter = 0;
		float tmp;

		for (int i = resulution; i > 1; i--) {
			for (int j = i; j >= 1; j--) {
				if (gcd(j, i) != 1)
					continue;
				tmp = (float) j /(float) i;
				if (tmp > min && tmp < max)
					counter++;
			}

		}

		return counter;
	}

	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

}
