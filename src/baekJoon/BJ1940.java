package baekJoon;

import java.util.*;
import java.io.*;

public class BJ1940 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int l=0, r=n-1, cnt=0;
		while (l < r) {
			if (arr[l] + arr[r] < m) l++;
			else if (arr[l] + arr[r] > m) r--;
			else {
				cnt++;
				l++;
				r--;
			}
		}

		System.out.println(cnt);
	}
}
