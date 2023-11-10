package baekJoon;

import java.util.*;
import java.io.*;

public class BJ1012 {
	static int[][] map;
	static int n, m, t;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int c = 0; c<t; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			map = new int[n][m];

			for (int i = 0; i<k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}

			int cnt = 0;

			for (int i = 0; i<n; i++) {
				for (int j = 0; j<m; j++) {
					if (map[i][j] == 1) {
						map[i][j] = 0;
						DFS(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	static void DFS(int x, int y) {
		for (int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]==1) {
				map[nx][ny] = 0;
				DFS(nx, ny);
			}
		}
	}
}
