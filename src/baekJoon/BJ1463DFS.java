package baekJoon;

import java.io.*;

public class BJ1463DFS {

	static int count = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		DFS(n, 0);
		System.out.println(count);

	}

	static void DFS(int n, int L) {
		if (L > count) return;
		if (n == 1) {
			count = Math.min(count, L);
		}
		else {
			if (n % 3 == 0) DFS(n/3, L+1);
			if (n % 2 == 0) DFS(n/2, L+1);
			DFS(n-1, L+1);
		}

	}
}
