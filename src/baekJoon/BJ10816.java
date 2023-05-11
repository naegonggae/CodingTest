package baekJoon;

import java.util.*;
import java.io.*;

public class BJ10816 {

	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		m = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i<m; i++) {
			int checkNum = Integer.parseInt(st.nextToken());
			int result = upperBound(checkNum) - lowerBound(checkNum);
			sb.append(result+" ");
		}

		System.out.println(sb);

	}

	static int lowerBound(int checkNum) {
		int hi = n;
		int lo = 0;

		while (lo < hi) {
			int mid = (hi+lo) / 2;

			if (checkNum <= arr[mid]) {
				hi = mid;
			}
			else {
				lo = mid + 1;
			}
		}

		return lo;
	}

	static int upperBound(int checkNum) {
		int hi = n;
		int lo = 0;

		while (lo < hi) {
			int mid = (hi + lo) / 2;

			if (checkNum < arr[mid]) {
				hi = mid;
			} else {
				lo = mid+1;
			}
		}
		return hi;
	}
}
