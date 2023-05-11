package baekJoon;

import java.io.*;

public class BJ1992 {
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());

		board = new int[n][n];
		for (int i = 0; i<n; i++) {
			String line = bf.readLine();
			for (int j = 0; j<n; j++) {
				board[i][j] = line.charAt(j)-'0';
			}
		}

		partition(0, 0, n);
	}

	static void partition(int row, int col, int size) {

		if (numberCheck(row, col, size)) {
			System.out.print(board[row][col]);

			return;
		}

		int newSize = size / 2;

		System.out.print("(");

		partition(row, col, newSize);
		partition(row, col + newSize, newSize);

		partition(row + newSize, col, newSize);
		partition(row + newSize, col + newSize, newSize);

		System.out.print(")");

	}

	static boolean numberCheck(int row, int col, int size) {
		int number = board[row][col];

		for (int i = row; i<row+size; i++) {
			for (int j = col; j<col+size; j++) {
				if (number != board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
