package baekJoon;

import java.util.*;
import java.io.*;

public class BJ1520 {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int m, n;
	static int[][] map, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[m+1][n+1];
		dp = new int[m+1][n+1];
		for (int i = 1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(1, 1));
	}

	static int dfs(int x, int y) {
		if (x==m && y==n)return 1;
		if (dp[x][y] != -1) return dp[x][y];
		dp[x][y] = 0;
		for (int i = 0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (nx>m || ny>n || nx<1 || ny<1) continue;
			if (map[x][y] > map[nx][ny]) dp[x][y] += dfs(nx, ny);
		}
		return dp[x][y];
	}
}