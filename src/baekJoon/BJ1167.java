package baekJoon;

import java.util.*;
import java.io.*;

public class BJ1167{

	static ArrayList<Node>[] al;
	static boolean[] visited;
	static int node;
	static int max = 0;


	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());

		al = new ArrayList[num+1];
		for (int i = 1; i<num+1; i++) {
			al[i] = new ArrayList<>();
		}
		for (int i = 0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int m = Integer.parseInt(st.nextToken());

			while (true) {
				int end = Integer.parseInt(st.nextToken());
				if (end == -1) break;
				int cost = Integer.parseInt(st.nextToken());
				al[m].add(new Node(end, cost));
			}
		}

		visited = new boolean[num+1];
		dfs(2, 0);

		visited = new boolean[num+1];
		dfs(node, 0);

		System.out.println(max);
	}

	public static void dfs(int a, int len) {
		if (len > max) {
			max = len;
			node = a;
		}
		visited[a] = true;

		for (int i = 0; i<al[a].size(); i++) {
			Node n = al[a].get(i);
			if (visited[n.x] == false) {
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

