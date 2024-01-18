package baekJoon;

import java.util.*;
import java.io.*;

public class BJ13305 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long[] dis = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i<n-1; i++) {
			dis[i] = Long.parseLong(st.nextToken());
		}

		long[] gas = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i<n; i++) {
			gas[i] = Long.parseLong(st.nextToken());
		}

		long money = gas[0]*dis[0];
		long num = gas[0];
		for (int i = 1; i<n-1; i++) {
			if (num > gas[i]) {
				num = gas[i];
			}
			money += num*dis[i];
		}

		System.out.println(money);

	}
}
