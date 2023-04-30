package baekJoon;

import java.util.*;
import java.io.*;

public class BJ2178{

	static class Miro {
		int x;
		int y;
		int moved;

		public Miro(int x, int y, int moved) {
			this.x = x;
			this.y = y;
			this.moved = moved;
		}
	}

	static int[][] graph;
	static int m, n;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(bf.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		graph = new int[m+1][n+1];

		for (int i = 1; i<m+1; i++) {
			String input = bf.readLine();
			for (int j = 0; j<n; j++) {
				graph[i][j+1] = input.charAt(j)-'0';
			}
		}

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Miro> queue = new LinkedList<>();
		int moved = 0;

		queue.add(new Miro(1, 1, 1));

		while (!queue.isEmpty()) {
			Miro miro = queue.poll();
			moved = miro.moved;

			for (int i = 0; i<4; i++) {
				int nx = miro.x + dx[i];
				int ny = miro.y + dy[i];
				if (nx > 0 && ny > 0 && nx <= m && ny <= n) {

					if (graph[nx][ny] == 1) {
						graph[nx][ny] = 0;
						queue.add(new Miro(nx, ny, moved+1));
						if (nx == m && ny == n) {
							return moved+1;
						}
					}
				}
			}
		}

		return moved;
	}
}

