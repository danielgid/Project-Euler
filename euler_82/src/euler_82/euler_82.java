package euler_82;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class euler_82 {

	public static double[][] num;
	public static double[][] min_sum;
	


	public static void main(String[] args) throws FileNotFoundException {
		init();
		read_file_triangle();

		min_sum_check();
		find_min();
	}

	public static void print_matrix() {
		for (int raw = 0; raw < num.length; raw++) {
			for (int col = 0; col < num.length; col++)
				System.out.print(num[raw][col] + "  ");

			System.out.println("");
		}
	}
	
	
	public static void min_sum_check() {
		
		for (int col = 0; col < num.length; col++) {

			for (int raw = 0; raw < min_sum.length; raw++) {
				if (col == 0) {
					min_sum[raw][col] = num[raw][col];
					continue;
				}
				
				min_sum[raw][col] = Math.min(up_move(col, raw), bottom_move(col, raw));
			}
		}
	}
	
	public static double up_move(int col,int raw){
		double sum=num[raw][col];
		double min_col = (double) Integer.MAX_VALUE;
		
		for (int i = raw; i >= 0;) {

			if (min_col > sum + min_sum[i][col - 1])
				min_col = sum + min_sum[i][col - 1];
			i--;
			if (i >= 0)
				sum += num[i][col];
		}
		
		return min_col;
	}
	
	public static double bottom_move(int col,int raw) {
		double sum=num[raw][col];
		double min_col = (double) Integer.MAX_VALUE;
		
		for (int i = raw; i < min_sum.length;) {
			if (min_col > sum + min_sum[i][col - 1])
				min_col = sum + min_sum[i][col - 1];

			i++;
			if (i <= num.length - 1)
				sum += num[i][col];
		}
		
		return min_col;
	}

	public static void find_min() {
		double min = Double.MAX_VALUE;

		for (int raw = 0; raw < min_sum.length; raw++) {
			if (min > min_sum[raw][num.length - 1]) {
				min = min_sum[raw][num.length - 1];
			}
		}

		System.out.println(min);
	}

	public static void init() {
		num = new double[80][80];
		min_sum = new double[num.length][num.length];

		for (int col = 0; col < num.length; col++) {
			for (int raw = 0; raw < num[col].length; raw++) {
				num[col][raw] = 0;
				min_sum[col][raw] = (double) Integer.MAX_VALUE;
			}
		}
	}

	public static void read_file_triangle() throws FileNotFoundException {
		char c;
		int sum = 0;
		int tmp = 0, col = 0, raw = 0;

		FileReader inputStream = null;

		try {
			inputStream = new FileReader("p082_matrix.txt");

			while ((tmp = inputStream.read()) != -1) {
				c = (char) tmp;

				if (c == '\n') {
					num[col][raw++] = (double) sum;
					sum = 0;
					if (raw == num.length) {
						raw = 0;
						col++;
					}
				} else if (c == ',') {
					num[col][raw++] = (double) sum;
					sum = 0;
					if (raw == num.length) {
						raw = 0;
						col++;
					}
				} else if (c >= '0' && c <= '9') {
					sum *= 10;
					sum += (c - '0');
				}
			}
			if (raw < num.length && col < num.length)
				num[col][raw] = (double) sum;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
