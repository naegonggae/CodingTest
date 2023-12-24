package baekJoon;

import java.util.*;
import java.io.*;

public class BJ2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] coin = new int[n+1];
		for (int i = 1; i<=n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[m+1];
		dp[0] = 1;
		for (int i = 1; i<=n; i++) {
			for (int j = coin[i]; j<=m; j++) {
				dp[j] = dp[j] + dp[j - coin[i]];
			}
		}

		System.out.println(dp[m]);
	}
}
