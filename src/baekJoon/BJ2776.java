package baekJoon;

import java.util.*;
import java.io.*;

public class BJ2776 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int j = 0; j<t; j++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for (int i = 0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i<m; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				sb.append(findNum(arr, tmp) + "\n");
			}
		}

		System.out.println(sb);
	}

	static int findNum(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;

		while (lo < hi) {
			int mid = (lo + hi) /2;
			if (key == arr[mid]) return 1;
			if (key < arr[mid]) hi = mid;
			else lo = mid + 1;
		}
		return 0;
	}
}
