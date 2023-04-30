package baekJoon;

import java.util.*;
import java.io.*;

public class BJ7576{

	static class Tomato {
		int x;
		int y;
		int day;

		public Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	static int[][] box;
	static int n, m;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		box = new int[m+1][n+1];

		for (int i = 1; i<=m; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j<=n; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
	}

	static void bfs() {

		Queue<Tomato> queue = new LinkedList<>();
		int day = 0;

		for (int i = 1; i<m+1; i++) {
			for (int j = 1; j<n+1; j++) {
				if (box[i][j] == 1) {
					queue.add(new Tomato(i, j, 0));
				}
			}
		}

		while (!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			day = tomato.day;

			for (int i = 0; i<4; i++) {
				int nx = tomato.x + dx[i];
				int ny = tomato.y + dy[i];

				if (nx > 0 && ny > 0 && nx <= m && ny <=n) {
					if (box[nx][ny] == 0) {
						box[nx][ny] = 1;
						queue.add(new Tomato(nx, ny, day+1));
					}
				}
			}
		}

		if (checkTomato()) {
			System.out.println(day);
		} else {
			System.out.println(-1);
		}
	}

	static boolean checkTomato() {
		for (int i = 1; i<m+1; i++) {
			for (int j = 1; j<n+1; j++) {
				if (box[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}

