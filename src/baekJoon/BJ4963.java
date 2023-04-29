package baekJoon;

import java.util.*;
import java.io.*;

public class BJ4963{

	static boolean[][] check;
	static int[][] graph;
	static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
	static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
	static int n, m, count;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0) {
				break;
			}

			graph = new int[m+1][n+1];
			check = new boolean[m+1][n+1];
			int[] land = new int[65];
			count = 0;

			for (int i = 1; i<=m; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 1; j<=n; j++) {

					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 1; i<=m; i++) {
				for (int j = 1; j<=n; j++) {
					if (graph[i][j] == 1 && !check[i][j]) {
						count++;
						dfs(i, j);
					}
				}
			}

			System.out.println(count);
		}
	}

	static void dfs(int x, int y) {
		check[x][y] = true;

		for (int i = 0; i<8; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if (newX > 0 && newY >0 && newX <= m && newY <= n) {
				if (graph[newX][newY] == 1 && !check[newX][newY]) {
					dfs(newX, newY);
				}
			}
		}
	}

}

