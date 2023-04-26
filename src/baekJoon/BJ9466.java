package baekJoon;

import java.util.*;
import java.io.*;

public class BJ9466{
	static StringBuilder sb = new StringBuilder();
	static int[] graph;
	static boolean[] check, finish;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());

		for (int i = 0; i<n; i++) {
			int m = Integer.parseInt(bf.readLine());
			graph = new int[m+1];
			check = new boolean[m+1];
			finish = new boolean[m+1];
			cnt = 0;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 1; j<m+1; j++) {
				graph[j] = Integer.parseInt(st.nextToken());
			}

			for (int k = 1; k<graph.length; k++) {
				if (!finish[k]) {
					dfs(k);
				}
			}
			sb.append(m - cnt).append('\n');
		}
		System.out.print(sb);
	}

	static void dfs(int k) {
		if (check[k]) {
			finish[k] = true;
			cnt++;
		}
		else {
			check[k] = true;
		}

		if (!finish[graph[k]]) {
			dfs(graph[k]);
		}

		check[k] = false;
		finish[k] = true;
	}
}
