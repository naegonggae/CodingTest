package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10451 {
	static StringBuilder sb = new StringBuilder();
	static boolean[][] graph;
	static boolean[] check;
	static int a, M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		for (int i = 0; i<N; i++) {
			M = Integer.parseInt(bf.readLine());
			graph = new boolean[M+1][M+1];
			check = new boolean[M+1];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 1; j<M+1; j++) {
				a = Integer.parseInt(st.nextToken());
				graph[a][j] = graph[j][a] = true;
			}

			int cnt = 0;
			dfs(1);
			cnt++;
			for (int j = 1; j<check.length; j++) {
				if (!check[j]) {
					dfs(j);
					cnt++;
				}
			}
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}
	static void dfs(int N) {

		check[N] = true;

		for (int i = 0; i<M+1; i++) {
			if (graph[N][i] && !check[i]) {
				dfs(i);
			}
		}
	}
}

