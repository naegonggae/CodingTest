package baekJoon;

import java.util.*;
import java.io.*;

public class BJ2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int l=0, r=n-1, min=Integer.MAX_VALUE;
		int a=0, b=0;
		while (l<r) {
			int sum = arr[l] + arr[r];
			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				a = arr[l];
				b = arr[r];
			}
			if (sum <= 0) {
				l++;
			} else r--;


		}

		System.out.println(a+" "+b);
	}
}
