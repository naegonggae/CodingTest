package baekJoon;

import java.io.*;

public class BJ2579TD {

	static Integer[] dp;
	static int[] score;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		score = new int[n+1];
		for (int i = 1; i<=n; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}

		dp = new Integer[n+1];
		dp[0] = 0;
		dp[1] = score[1];
		if (n >= 2) dp[2] = Math.max(score[2], dp[1]+score[2]);

		System.out.println(recur(n));
	}

	static int recur(int n) {
		if (dp[n] == null) {
			dp[n] = Math.max(recur(n-2)+score[n], recur(n-3)+score[n-1]+score[n]);
		}
		return dp[n];
	}
}
