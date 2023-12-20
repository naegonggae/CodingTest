package baekJoon;

import java.util.*;
import java.io.*;

public class BJ11724 {

	static int n, m;
	static int[][] map;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n+1][n+1];

		for (int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}

		check = new boolean[n+1];
		int count = 0;
		for (int i = 1; i<=n; i++) {
			if (!check[i]) {
				count+=DFS(i);
			}
		}
		System.out.println(count);
	}

	static int DFS(int x) {
		check[x] = true;
		for (int i = 1; i<=n; i++) {
			if (map[x][i] == 1 && !check[i]) {
				DFS(i);
			}
		}

		return 1;
	}
}