package baekJoon;

import java.util.*;
import java.io.*;

public class BJ10942 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// dp
		int[][] dp = new int[n+1][n+1];
		for (int i = 1; i<=n; i++) {
			for (int j = 1; j<=n; j++) {
				if (arr[i] == arr[j]) dp[i][j] = 1;
				if (i > j) continue;
				else {
					int a = i;
					int b = j;
					boolean flag = true;
					while (a <= b) {
						if (arr[a++] == arr[b--]) continue;
						else {
							flag = false;
							break;
						}
					}
					if (flag) dp[i][j] = 1;
					else dp[i][j] = 0;
				}
			}
		}

		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int result = dp[s][e];
			sb.append(result+"\n");
		}

		System.out.println(sb.toString());
	}
}
