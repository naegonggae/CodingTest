package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2331 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int count = 1;
		int[] check = new int[240000];
		check[N] = count++;

		int result = dfs(N, M, check, count);
		System.out.println(result);

	}

	static int dfs(int N, int M, int[] check, int count) {

		String num = Integer.toString(N);
		int x = 0;
		for (int i = 0; i<num.length(); i++) {
			x += Math.pow(num.charAt(i)-'0', M);
		}
		if (check[x] != 0) {
			return check[x]-1;
		}
		check[x] = count++;

		return dfs(x, M, check, count);
	}

}

