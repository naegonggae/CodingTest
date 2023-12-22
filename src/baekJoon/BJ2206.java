package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206 {

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int n, m;
	static int[][] map;
	static boolean[][][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n+1][m+1];
		check = new boolean[2][n+1][m+1];

		for (int i = 1; i<=n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j<m; j++) {
				map[i][j+1] = tmp.charAt(j) - '0';
			}
		}

		System.out.println(BFS());
	}

	static int BFS() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(1, 1, 1, true));
		while (!q.isEmpty()) {
			Point tmp = q.poll();
			int cost = tmp.cost;

			if (tmp.x == n && tmp.y == m) {
				return cost;
			}
			for (int i = 0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx<=0 || ny<=0 || nx>n || ny>m) continue;
				if (map[nx][ny] == 1) {
					if (tmp.chance) q.add(new Point(nx, ny, tmp.cost+1, false));
					check[1][nx][ny] = true;
				}
				else {
					if (tmp.chance && !check[0][nx][ny]) {
						q.add(new Point(nx, ny, tmp.cost+1, true));
						check[0][nx][ny] = true;
					} else if (!tmp.chance && !check[1][nx][ny]) {
						q.add(new Point(nx, ny, tmp.cost+1, false));
						check[1][nx][ny] = true;
					}
				}
			}
		}

		return -1;
	}

	static class Point {
		int x, y, cost;
		boolean chance;
		public Point(int x, int y, int cost, boolean chance) {
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.chance = chance;
		}
	}
}
