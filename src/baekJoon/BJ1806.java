package baekJoon;

import java.util.*;
import java.io.*;

public class BJ1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int l=0, r=0, cnt=Integer.MAX_VALUE, sum=0;
		while (r < n) {
			if (sum <= s) sum += arr[r++];
			else sum -= arr[l++];

			if (sum >= s) {
				int len = r - l;
				cnt = Math.min(cnt, len);
			}
		}

		while (sum >= s) {
			sum -= arr[l++];
			if (sum >= s) {
				int len = r - l;
				cnt = Math.min(cnt, len);
			}
		}

		if (cnt == Integer.MAX_VALUE) {
			System.out.println(0);
			return;
		}
		System.out.println(cnt);
	}
}
