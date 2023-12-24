package baekJoon;

import java.io.*;

public class BJ9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();

		int lenA = a.length();
		int lenB = b.length();
		int[][] dp = new int[lenA+1][lenB+1];

		for (int i = 1; i<=lenA; i++) {
			for (int j = 1; j<=lenB; j++) {
				if (a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}

		System.out.println(dp[lenA][lenB]);
	}
}