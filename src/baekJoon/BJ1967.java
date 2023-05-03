package baekJoon;

import java.util.*;
import java.io.*;

public class BJ1967{
	static ArrayList<Node>[] al;
	static boolean[] visited;
	static int node;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());

		if(n == 1) {
			System.out.println(0);
		}
		else {
			al = new ArrayList[n + 1];
			for (int i = 1; i < n + 1; i++) {
				al[i] = new ArrayList<>();
			}

			for (int i = 0; i < n - 1; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				al[p].add(new Node(c, v));
				al[c].add(new Node(p, v));
			}

			visited = new boolean[n + 1];
			dfs(1, 0);

			visited = new boolean[n + 1];
			dfs(node, 0);

			System.out.println(max);
		}
	}

	public static void dfs(int a, int len) {
		if (max < len) {
			max = len;
			node = a;
		}

		visited[a] = true;

		for (int i = 0; i<al[a].size(); i++) {
			Node n = al[a].get(i);
			if (!visited[n.x]) {
				dfs(n.x, n.cost + len);
			}
		}
	}

	public static class Node {
		int x, cost;
		public Node(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
	}
}
