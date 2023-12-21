package baekJoon;

import java.util.*;
import java.io.*;

public class BJ2667 {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int n, cnt;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		for (int i = 0; i<n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j<n; j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}

		int count = 0;
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) {
				if (map[i][j]==1) {
					count++;
					al.add(DFS(i, j));
					cnt = 0;
				}
			}
		}

		Collections.sort(al);
		System.out.println(count);
		for (int num : al) {
			System.out.println(num);
		}
	}

	static int DFS(int x, int y) {
		map[x][y] = 0;
		cnt++;
		for (int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx<0 || ny<0 || nx>=n || ny>=n) continue;
			if (map[nx][ny]==0) continue;
			DFS(nx, ny);
		}

		return cnt;
	}
}