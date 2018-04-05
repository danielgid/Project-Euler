package eruler_96;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class euler_96 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int sum = 0;
		int[][] board = new int[9][9];
		int[][][] boards = readBoardFromFile("p096_sudoku.txt");
		for (int k = 1; k < 51; k++) {

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					board[i][j] = boards[k][i][j];
				}
			}

			//System.out.println(k + ":");
			solveSudoku(board);
			// printBoard(board);

			for (int i = 0; i < board.length; i++) {

				for (int j = 0; j < board.length; j++) {
					boards[k][i][j] = board[i][j];
				}
			}

		}

		int tmp = 0;
		for (int k = 1; k < boards.length; k++) {
			tmp = 0;
			for (int j = 0; j < 3; j++) {
				tmp *= 10;
				tmp += boards[k][0][j];
			}
			sum += tmp;
		}

		System.out.println(sum);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime + "ms");
	}

	// ************** Sudoku - Read Board From Input File **************
	public static int[][][] readBoardFromFile(String fileToRead) {
		int k = 0;
		int[][][] boards = new int[51][9][9];
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToRead));

			int row = 0;
			String line;
			while ((line = bufferedReader.readLine()) != null) {

				for (int column = 0; column < line.length(); column++) {
					char c = line.charAt(column);
					if (c <= '9' && c >= '0') {
						boards[k][row][column] = c - '0';
					} else if (c == 'G') {
						k++;
						row = -1;
						break;
					} else {

					}
				}
				row++;
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return boards;
	}

	// ************** Sudoku - Part1 (iterative) **************
	public static int[][][] eliminateDomains(int[][] board) {
		int tmp = 0;

		int[][][] domains = init(board);

		do {
			for (int i = 0; i < domains.length; i++) {
				for (int j = 0; j < domains.length; j++) {
					if (board[i][j] != 0) {
						tmp = board[i][j] - 1;

						for (int row = 0; row < domains.length; row++) {
							if (domains[row][j][tmp] != 0)
								domains[row][j][tmp] = -1;
						}

						for (int col = 0; col < domains.length; col++) {
							if (domains[i][col][tmp] != 0)
								domains[i][col][tmp] = -1;
						}

						int boxRowOffset = (i / 3) * 3;
						int boxColOffset = (j / 3) * 3;

						for (int row = 0; row < 3; row++) {
							for (int col = 0; col < 3; col++) {
								if (domains[boxRowOffset + row][boxColOffset + col][tmp] != 0)
									domains[boxRowOffset + row][boxColOffset + col][tmp] = -1;
							}
						}
					} // if the board not null
				} // for j
			} // for i
		} while (fill(domains, board));

		return domains;
	}

	public static int[][][] init(int[][] board) {
		int tmp = 0;
		int[][][] domains = new int[9][9][9];

		for (int i = 0; i < domains.length; i++) {
			for (int j = 0; j < domains.length; j++) {
				if (board[i][j] == 0)
					tmp = 1;
				else
					tmp = 0;

				for (int k = 0; k < domains.length; k++) {
					domains[i][j][k] = tmp;
				}
			}
		}

		return domains;
	}

	public static boolean fill(int[][][] domains, int[][] board) {
		int tmp = 0, counter = 0;
		boolean result = false;

		for (int i = 0; i < domains.length; i++) {
			for (int j = 0; j < domains.length; j++) {
				if (board[i][j] == 0) {
					counter = 0;
					for (int k = 0; k < board.length; k++) {
						if (domains[i][j][k] == 1) {
							counter++;
							tmp = k;
						}
					}

					if (counter == 1) {
						result = true;
						board[i][j] = tmp + 1;

						for (int row = 0; row < domains.length; row++) {
							if (domains[row][j][tmp] != 0)
								domains[row][j][tmp] = -1;
						}

						for (int col = 0; col < domains.length; col++) {
							if (domains[i][col][tmp] != 0)
								domains[i][col][tmp] = -1;
						}

						int boxRowOffset = (i / 3) * 3;
						int boxColOffset = (j / 3) * 3;

						for (int row = 0; row < 3; row++) {
							for (int col = 0; col < 3; col++) {
								if (domains[boxRowOffset + row][boxColOffset + col][tmp] != 0)
									domains[boxRowOffset + row][boxColOffset + col][tmp] = -1;
							}
						}

						for (int k = 0; k < board.length; k++) {
							domains[i][j][k] = 0;
						}
					} // counter =1
				} // if the board not null
			} // for j
		} // for i

		return result;
	}

	public static void printBoard(int[][] board) {

		for (int i = 0; i < board.length; i++) {
			if (i % 3 == 0 && i != 0)
				System.out.println("---+---+---");

			for (int j = 0; j < board.length; j++) {
				if (j % 3 == 0 && j != 0)
					System.out.print("|");
				System.out.print(board[i][j]);
			}
			System.out.println();

		}

	}

	// ************** Sudoku - Part2 (recursive) **************
	public static boolean solveSudoku(int[][] board) {
		int row = 0, col = 0;
		int[][][] domains = eliminateDomains(board);
		int[] index = new int[2];// index[0]=row,index[1]=col

		if (if_full(board, index, 0, 0)) {
			return true;
		}
		row = index[0];
		col = index[1];

		int[][] tmp_board = new int[9][9];
		
		return all_options(domains, board, tmp_board, row, col, 0);
	}

	public static boolean all_options(int[][][] domains, int[][] board, int[][] tmp_board, int row, int col, int k) {

		if (k == 9)
			return false;

		if (domains[row][col][k] == 1) {
			cpy_arr(board, tmp_board, 0, 0);

			tmp_board[row][col] = k + 1;

			if (solveSudoku(tmp_board)) {
				cpy_arr(tmp_board, board, 0, 0);
				return true;
			}
		}

		return all_options(domains, board, tmp_board, row, col, (k+1));
	}

	public static boolean if_full(int[][] board, int[] index, int i, int j) {
		if (i == board.length)
			return true;

		if (board[i][j] == 0) {
			index[0] = i;
			index[1] = j;
			return false;
		}

		j++;
		if (j == board.length) {
			j = 0;
			i++;
		}

		return if_full(board, index, i, j);
	}

	public static void cpy_arr(int[][] from_board, int[][] des_board, int i, int j) {
		if (i == 9)
			return;

		des_board[i][j] = from_board[i][j];

		if (j == 8) {
			j = 0;
			i++;
		} else {
			j++;
		}

		cpy_arr(from_board, des_board, i, j);
	}

}
