public class Euler_28 {
	public static int[][] matrix;
	public static int raw;
	public static int col;
	public static char direct;

	public static void main(String[] args) {
		matrix = new int[1001][1001];
		raw = 0;
		col = matrix.length - 1;
		direct = 'l';

		System.out.println("Start fill matrix");
		fill((int) Math.pow(matrix.length, 2));
		System.out.println("End fill matrix");

		System.out.println("The sum in diagonal: " + diagonalSum());

	}

	public static void fill(int number) {
		while (number != 0) {
			if (raw < 0 || col < 0 || raw == matrix.length
					|| col == matrix.length)
				changeDirect();
			if (matrix[raw][col] != 0)
				changeDirect();

			matrix[raw][col] = number;
			setNext();
			number--;
		}
	}

	public static void changeDirect() {
		if (direct == 'u') {
			raw++;
			col--;
			direct = 'l';
		} else if (direct == 'd') {
			raw--;
			col++;
			direct = 'r';
		} else if (direct == 'l') {
			raw++;
			col++;
			direct = 'd';
		} else if (direct == 'r') {
			raw--;
			col--;
			direct = 'u';
		}
	}

	public static void setNext() {
		switch (direct) {
		case 'u':
			raw--;
			break;
		case 'd':
			raw++;
			break;
		case 'l':
			col--;
			break;
		case 'r':
			col++;
			break;
		default:
			break;
		}
	}

	public static int diagonalSum() {
		int sum = 0;
		int raw = 0, col = 0;

		for (; raw < matrix.length; raw++) {
			sum += matrix[raw][col];
			col++;
		}

		raw--;
		col = 0;

		for (; raw >= 0; raw--) {
			if (raw != col)
				sum += matrix[raw][col];
			col++;
		}

		return sum;
	}

	public static void print() {

		int i = 0, j = 0;
		for (; i < matrix.length; i++) {
			for (j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
