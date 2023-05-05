package baekJoon;

import java.util.*;
import java.io.*;

public class BJ2805{

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		int max = 0;

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		int min = 0;
		int mid = 0;

		while (min < max) {
			long len = 0;
			mid = (max + min) / 2;

			for (int i = 0; i<arr.length; i++) {
				if (arr[i] - mid > 0) {
					len += arr[i] - mid;
				}
			}

			if (len < m) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
		}
		System.out.println(min-1);
	}
}

