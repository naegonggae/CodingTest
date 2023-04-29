package baekJoon;

import java.util.*;
import java.io.*;

public class BJ2667{

	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static int[] apart = new int[25*25];
	static int n;
	static int apartNum = 0;
	static boolean[][] visited = new boolean[25][25];
	static int[][] map = new int[25][25];

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i<n; i++) {
			String input = bf.readLine();
			for (int j = 0; j<n; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}

		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					apartNum++;
					dfs(i, j);
				}
			}
		}

		Arrays.sort(apart);
		System.out.println(apartNum);

		for (int i = 0; i<apart.length; i++) {
			if (apart[i] == 0) {
			} else {
				System.out.println(apart[i]);
			}
		}
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		apart[apartNum]++;

		for (int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}
}

