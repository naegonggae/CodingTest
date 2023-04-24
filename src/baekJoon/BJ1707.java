package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1707 {
	static int[] check;
	static ArrayList<Integer>[] al;
	static int A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());

		for (int i = 0; i<num; i++) {
			StringTokenizer st  = new StringTokenizer(bf.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			al = new ArrayList[A+1];
			check = new int[A+1];

			for (int j = 0; j<=A; j++) {
				al[j] = new ArrayList<Integer>();
			}
			for (int j = 0; j<B; j++) {
				StringTokenizer st2 = new StringTokenizer(bf.readLine());
				int N = Integer.parseInt(st2.nextToken());
				int M = Integer.parseInt(st2.nextToken());
				al[N].add(M);
				al[M].add(N);
			}
			bfs();
		}
	}

	static void bfs() {

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i<=A; i++) {
			if (check[i] == 0) {
				queue.add(i);
				check[i] = 1;
			}
			while (!queue.isEmpty()) {
				int now = queue.poll();
				for (int j = 0; j<al[now].size(); j++) {
					if (check[al[now].get(j)] == 0) {
						queue.add(al[now].get(j));
					}
					if(check[al[now].get(j)] == check[now]) {
						System.out.println("NO");
						return;
					}

					if(check[now] == 1 && check[al[now].get(j)] == 0)
						check[al[now].get(j)] = 2;
					else if(check[now] == 2 && check[al[now].get(j)] == 0)
						check[al[now].get(j)] = 1;
				}
			}
		}
		System.out.println("YES");

	}
}

