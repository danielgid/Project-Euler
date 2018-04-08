import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Euler_81 {
	public static int[][] matrix;
	public static int[][] sum;

	public static void main(String[] args) {
		matrix = new int[80][80];
		sum = new int[80][80];

		try {
			fillMatrix();
			System.out.println("The sum of two ways is : " + sumTwoWays());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void fillMatrix() throws IOException {
		int temp, num = 0, raw = 0, col = 0;
		FileReader f = null;
		BufferedReader b = null;

		try {
			f = new FileReader("p081_matrix.txt");
			b = new BufferedReader(f);

			while ((temp = b.read()) != -1) {
				if (temp == 44 || temp == '\n') {
					if (col == matrix.length) {
						col = 0;
						raw++;
					}
					matrix[raw][col++] = num;
					num = 0;
				} else {
					num *= 10;
					num += temp - '0';
				}
			}

			if (col < matrix.length && raw < matrix.length)
				matrix[raw][col] = num;

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (f != null) {
				f.close();
			}
		}// finally
	}

	public static long sumTwoWays() {
		int col = matrix.length - 1, raw = matrix.length - 1;

		while (col != 0 || raw != 0) {
			if (col == matrix.length - 1) {
				if (raw != matrix.length - 1)
					sum[raw][col] += sum[raw + 1][col];

			} else {
				if (raw != matrix.length - 1) {
					if (sum[raw + 1][col] > sum[raw][col + 1])
						sum[raw][col] += sum[raw][col + 1];
					else
						sum[raw][col] += sum[raw + 1][col];
				} else {
					sum[raw][col] += sum[raw][col + 1];
				}
			}

			sum[raw][col] += matrix[raw][col--];

			if (col < 0) {
				col = matrix.length - 1;
				raw--;
			}
		}

		if (sum[raw + 1][col] > sum[raw][col + 1])
			sum[raw][col] += sum[raw][col + 1];
		else
			sum[raw][col] += sum[raw + 1][col];
		sum[raw][col] += matrix[raw][col];

		return sum[raw][col];
	}
}
