package baekJoon;

import java.util.*;
import java.io.*;

public class BJ2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] num = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int l = 0, r = 0, sum = 0, cnt = 0;
		while (true) {
			if (sum >= m) sum -= num[l++];
			else if (r == n) break;
			else sum += num[r++];

			if (sum == m) cnt++;
		}

		System.out.println(cnt);
	}
}