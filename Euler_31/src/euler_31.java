public class euler_31 {
	public static int counter = 0;

	public static void main(String[] args) {
		coin_subber(200, 200);

		System.out.println(counter);
	}

	public static void coin_subber(int value, int step) {
		if (value < 0)
			return;

		if (value == 0) {
			counter++;
			return;
		}

		switch (step) {
		case 200:
			coin_200(value, 200);
			break;
		case 100:
			coin_100(value, 100);
			break;
		case 50:
			coin_50(value, 50);
			break;
		case 20:
			coin_20(value, 20);
			break;
		case 10:
			coin_10(value, 10);
			break;
		case 5:
			coin_5(value, 5);
			break;
		case 2:
			coin_2(value, 2);
			break;
		case 1:
			coin_1(value, 1);
			break;
		}

	}

	public static void coin_200(int value, int step) {
		coin_subber(value - 200, 200);
		coin_subber(value - 100, 100);

		coin_subber(value - 50, 50);
		coin_subber(value - 20, 20);
		coin_subber(value - 10, 10);

		coin_subber(value - 5, 5);
		coin_subber(value - 2, 2);
		coin_subber(value - 1, 1);
	}

	public static void coin_100(int value, int step) {
		coin_subber(value - 100, 100);

		coin_subber(value - 50, 50);
		coin_subber(value - 20, 20);
		coin_subber(value - 10, 10);

		coin_subber(value - 5, 5);
		coin_subber(value - 2, 2);
		coin_subber(value - 1, 1);
	}

	public static void coin_50(int value, int step) {
		coin_subber(value - 50, 50);
		coin_subber(value - 20, 20);
		coin_subber(value - 10, 10);

		coin_subber(value - 5, 5);
		coin_subber(value - 2, 2);
		coin_subber(value - 1, 1);
	}

	public static void coin_20(int value, int step) {
		coin_subber(value - 20, 20);
		coin_subber(value - 10, 10);

		coin_subber(value - 5, 5);
		coin_subber(value - 2, 2);
		coin_subber(value - 1, 1);
	}

	public static void coin_10(int value, int step) {
		coin_subber(value - 10, 10);

		coin_subber(value - 5, 5);
		coin_subber(value - 2, 2);
		coin_subber(value - 1, 1);
	}

	public static void coin_5(int value, int step) {
		coin_subber(value - 5, 5);
		coin_subber(value - 2, 2);
		coin_subber(value - 1, 1);
	}

	public static void coin_2(int value, int step) {
		coin_subber(value - 2, 2);
		coin_subber(value - 1, 1);
	}

	public static void coin_1(int value, int step) {
		coin_subber(value - 1, 1);
	}

}
