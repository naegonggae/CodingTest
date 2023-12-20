package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1182 {
	static int n, s;
	static int result = 0;
	static boolean[] check;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[n];
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		check = new boolean[n];
		DFS(0, 0);
		System.out.println(result);
	}

	static void DFS(int L, int sum) {
		if (L == n) {
			if (sum == s) {
				result++;
			}
			return;
		} else {
			DFS(L+1, sum+arr[L]); // 사용함
			DFS(L+1, sum); // 사용안함
		}
	}
}
