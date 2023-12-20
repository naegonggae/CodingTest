package baekJoon;

import java.util.*;
import java.io.*;

public class BJ2468 {

	static int n;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		int maxHeight = 0;
		for (int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j<n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if (tmp > maxHeight) maxHeight = tmp;
			}
		}
		int result = 0;
		for (int height = 0; height<=maxHeight; height++) {

			check = new boolean[n][n];
			int count = 0; // 높이마다 안전지대 개수

			for (int i = 0; i<n; i++) {
				for (int j = 0; j<n; j++) {
					if (!check[i][j] && map[i][j] > height) {
						count+=DFS(i, j, height);
					}
				}
			}
			result = Math.max(result, count);
		}
		System.out.println(result);
	}

	static int DFS(int x, int y, int height) {
		check[x][y] = true;
		for (int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx<0 || ny<0 || nx>n-1 || ny>n-1) continue;
			if (check[nx][ny]) continue;
			if (map[nx][ny] > height) {
				DFS(nx, ny, height);
			}
		}
		return 1;
	}
}