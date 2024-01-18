package baekJoon;

import java.io.*;

public class BJ14916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] coin = {0, 2, 5};
		int[] dp = new int[n+1];
		for (int i = 1; i<=n; i++) {
			dp[i] = Integer.MAX_VALUE-1;
		}

		for (int i = 1; i<=2; i++) {
			for (int j = coin[i]; j<=n; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]]+1);
			}
		}

		if (dp[n] == Integer.MAX_VALUE-1) System.out.println(-1);
		else System.out.println(dp[n]);
	}
}