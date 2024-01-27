package baekJoon;

import java.util.*;
import java.io.*;

public class BJ2473 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int a=0, b=0, c=0;
		long min = Long.MAX_VALUE;

		for (int i = 0; i<n-2; i++) {
			int l = i+1;
			int r = n-1;

			while (l<r) {
				long tmp = (long) arr[i] + arr[l] + arr[r];
				if (min > Math.abs(tmp)) {
					min = Math.abs(tmp);
					a=arr[i]; b=arr[l]; c=arr[r];
				}

				if (tmp <= 0) l++;
				else r--;
			}
		}

		System.out.println(a+" "+b+" "+c);


	}
}
