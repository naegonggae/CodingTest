package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int len = s.length();
		int[] dp = new int[len+1];
		if (s.charAt(0) == '0') {
			System.out.println(0);
			return;
		}
		else {
			dp[0] = 1;
			dp[1] = 1;
			for (int i = 2; i<=len; i++) {
				if (s.charAt(i-1) == '0') {
					if (s.charAt(i-2) == '1' || s.charAt(i-2) == '2') dp[i] = dp[i-2] % 1000000;
					else break;
				}
				else {
					int num = Integer.valueOf(s.substring(i - 2, i));
					if (num > 26 || num < 10) dp[i] = dp[i-1] % 1000000;
					else dp[i] = (dp[i-1] + dp[i-2]) % 1000000;
				}
			}
		}

		System.out.println(dp[len]);
	}
}