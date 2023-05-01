package baekJoon;

import java.util.*;
import java.io.*;

public class BJ2146{

	static class Land {
		int x;
		int y;
		int bridge;

		public Land(int x, int y, int bridge) {
			this.x = x;
			this.y = y;
			this.bridge = bridge;
		}
	}
	static int[][] map;
	static int m;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int landNum = 2;
	static boolean[][] visited;

	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(bf.readLine());

		map = new int[m+1][m+1];

		for (int i = 1; i<m+1; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 1; j<m+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[m+1][m+1];

		for (int i = 1; i<m+1; i++) {
			for (int j = 1; j<m+1; j++) {
				if (map[i][j] == 1) {
					makeLand(i, j);
				}
			}
		}

		for (int i = 1; i<m+1; i++) {
			for (int j = 1; j<m+1; j++) {
				if (map[i][j] >= 2) {
					visited = new boolean[m+1][m+1];
					bfs(i, j);
				}
			}
		}

		System.out.println(answer);
	}

	static void makeLand(int i, int j) {
		Queue<Land> q = new LinkedList<>();
		q.add(new Land(i, j, 0));
		visited[i][j] = true;
		map[i][j] = landNum;
		while (!q.isEmpty()) {
			Land land = q.poll();
			for (int k = 0; k<4; k++) {
				int nx = land.x + dx[k];
				int ny = land.y + dy[k];
				if ((nx > 0 && ny > 0 && nx <= m && ny <= m) && !visited[nx][ny]
						&& map[nx][ny] == 1) {
					visited[nx][ny] = true;
					map[nx][ny] = landNum;
					q.add(new Land(nx, ny, 0));
				}
			}
		}
		landNum++;
	}
	static void bfs(int i, int j) {
		Queue<Land> q = new LinkedList<>();
		q.add(new Land(i, j, 0));
		int currentLandNum = map[i][j];
		visited[i][j] = true;

		while (!q.isEmpty()) {
			Land land = q.poll();

			for (int k = 0; k<4; k++) {
				int nx = land.x + dx[k];
				int ny = land.y + dy[k];
				if ((nx > 0 && ny > 0 && nx <= m && ny <= m) && !visited[nx][ny] && map[nx][ny] != currentLandNum) {
					visited[nx][ny] = true;
					if (map[nx][ny] == 0) {
						q.add(new Land(nx, ny, land.bridge+1));
					} else {
						answer = Math.min(answer, land.bridge);
					}
				}
			}
		}
	}
}

