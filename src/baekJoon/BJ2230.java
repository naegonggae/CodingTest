package baekJoon;

import java.util.*;
import java.io.*;

public class BJ2230 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int l=0, r=0, cnt=Integer.MAX_VALUE;
		while (r < n-1) {
			if (arr[r] - arr[l] <= m) r++;
			else l++;

			if (arr[r] - arr[l] >= m) {
				cnt = Math.min(cnt, arr[r] - arr[l]);
			}
		}

		while (arr[r] - arr[l] > m && l<r) {
			l++;
			if (arr[r] - arr[l] >= m) {
				cnt = Math.min(cnt, arr[r] - arr[l]);
			}
		}

		System.out.println(cnt);
	}
}
