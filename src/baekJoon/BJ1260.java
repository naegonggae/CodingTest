package baekJoon;

import java.util.*;
import java.io.*;

public class BJ1260 {
	static int n, m;
	static int[][] map;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		map = new int[n+1][n+1];
		for (int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}
		check = new boolean[n+1];
		DFS(v);
		System.out.println();
		check = new boolean[n+1];
		BFS(v);

	}

	static void DFS(int num) {
		System.out.print(num+ " ");
		check[num] = true;
		for (int i = 1; i<=n; i++) {
			if (!check[i] && map[num][i]==1) {
				DFS(i);
			}
		}
	}

	static void BFS(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		check[num] = true;
		System.out.print(num+" ");
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for (int i = 1; i<=n; i++) {
				if (!check[i] && map[tmp][i]==1) {
					q.add(i);
					check[i] = true;
					System.out.print(i+" ");
				}
			}
		}
	}
}