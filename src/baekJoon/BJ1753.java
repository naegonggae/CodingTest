package baekJoon;

import java.util.*;
import java.io.*;

public class BJ1753 {

	static List<Node>[] list;
	static int[] dp;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());

		list = new ArrayList[n+1];
		dp = new int[n+1];
		check = new boolean[n+1];

		for (int i = 1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list[from].add(new Node(to, cost));
		}

		dijkstra(k);
		for (int i = 1; i<dp.length; i++) {
			if (dp[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dp[i]);
		}
	}

	static void dijkstra(int start) {
		Queue<Node> q = new PriorityQueue<>();
		Arrays.fill(dp, Integer.MAX_VALUE);
		q.add(new Node(start, 0));
		dp[start] = 0;
		while (!q.isEmpty()) {
			Node node = q.poll();
			int to = node.to;

			if (check[to]) continue;
			check[to] = true;
			for (Node next : list[to]) {
				if (dp[next.to] >= dp[to] + next.cost) {
					dp[next.to] = dp[to] + next.cost;
					q.add(new Node(next.to, dp[next.to]));
				}
			}
		}

	}

	static class Node implements Comparable<Node> {
		int to, cost;
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}