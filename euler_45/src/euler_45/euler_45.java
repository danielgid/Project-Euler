package euler_45;

public class euler_45 {
	private static final int max_size = 10000000;
	public static long[] triangles;
	public static long[] pentagonal;
	public static long[] hexagonal;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		// set_all_numbers();
		// print_triangles();
		System.out.println(find_next(startTime));
	}

	public static void print_triangles() {
		for (int i = 0; i < triangles.length; i++) {
			System.out.println(i + "\t" + triangles[i]);
		}
	}

	public static int find_next(long startTime) {
		long j = 166, k = 144;

		do {
			if (get_hexagonal(k) == get_pentagonal(j)) {
				Long d = new Long(get_hexagonal(k));
				System.out.println(d.toString() + "\t" + j + "\t" + k);
				long endTime = System.currentTimeMillis();
				long totalTime = endTime - startTime;
				System.out.println(totalTime + "ms");
				break;


			} else if (get_hexagonal(k) < get_pentagonal(j)) {
				k+=1;

			} else {
				j+=1;

			}

		} while (j < Long.MAX_VALUE / 7);

		return -1;
	}

	public static long get_triangles(long n) {
		long solution = ((n * (n + 1)) / 2);
		return solution;
	}

	public static long get_pentagonal(long n) {
		long solution = ((n * (3 * n - 1)) / 2);
		return solution;
	}

	public static long get_hexagonal(long n) {
		long solution = (n * (2 * n - 1));
		return solution;
	}

	public static void set_all_numbers() {
		init();
		triangles_set();
		pentagonal_set();
		hexagonal_set();
	}

	public static void triangles_set() {
		int tmp = 0;

		for (int i = 0; i < max_size; i++) {
			tmp = i * (i + 1) / 2;

			triangles[i] = (long) tmp;
		}
	}

	public static void pentagonal_set() {
		int tmp = 0;

		for (int i = 0; i < max_size; i++) {
			tmp = i * (3 * i - 1) / 2;

			pentagonal[i] = (long) tmp;
		}
	}

	public static void hexagonal_set() {
		int tmp = 0;

		for (int i = 0; i < max_size; i++) {
			tmp = i * (2 * i - 1);
			hexagonal[i] = (long) tmp;
		}
	}

	public static void init() {
		triangles = new long[max_size];
		pentagonal = new long[max_size];
		hexagonal = new long[max_size];

		for (int i = 0; i < hexagonal.length; i++) {
			triangles[i] = 0;
			pentagonal[i] = 0;
			hexagonal[i] = 0;
		}
	}

}
