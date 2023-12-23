package baekJoon;

import java.util.*;
import java.io.*;

public class BJ1463BottomUp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n+1];
		dp[0] = dp[1] = 0;

		for (int i = 2; i<=n; i++) {
			// 1을 빼는 경우
			dp[i] = dp[i-1] + 1;
			// 2로 나눠지는 경우
			if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] +1);
			// 3으로 나눠지는 경우
			if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] +1);
		}

		System.out.println(dp[n]);
	}
}
