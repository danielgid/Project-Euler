package euler_76;

public class euler_76 {

	public static void main(String[] args) {
		euler76(100l);

	}

	public static void euler76(long target) {
		int i = 1, j = 0;
		long[] options = new long[(int) target + 1];
		options[0] = 1;

		for (; i < target; i++) {
			for (j = i; j <= target; j++) {
				options[j] += options[j - i];
			}
		}

		System.out.println(options[(int) target]);
	}

}
