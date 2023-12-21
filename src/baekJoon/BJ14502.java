package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14502 {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int n, m, result;
	static int[][] map;
	static ArrayList<Point> al = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					al.add(new Point(i, j));
				}
			}
		}

		DFS(0);
		System.out.println(result);
	}

	static void DFS(int L) {
		if (L == 3) {
			result = Math.max(result, BFS());
		}
		else {
			for (int i = 0; i<n; i++) {
				for (int j = 0; j<m; j++) {
					if (map[i][j]==0) {
						map[i][j] = 1;
						DFS(L+1);
						map[i][j] = 0;
					}
				}
			}
		}
	}

	static int BFS() {
		int[][] copyMap = new int[n][m];
		for (int i = 0; i<n; i++) {
			copyMap[i] = map[i].clone();
		}

		Queue<Point> q = new LinkedList<>();
		for (Point point : al) {
			q.add(point);
		}
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			for (int i = 0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx<0 || ny<0 || nx>=n || ny>=m) continue;
				if (copyMap[nx][ny]==1 || copyMap[nx][ny]==2) continue;
				copyMap[nx][ny] = 2;
				q.add(new Point(nx, ny));
			}
		}

		int count = 0;
		for (int[] i : copyMap) {
			for (int j : i) {
				if (j==0) {
					count++;
				}
			}
		}
		return count;
	}

	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
