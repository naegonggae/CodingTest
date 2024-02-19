package baekJoon;

import java.util.*;
import java.io.*;

public class BJ2512 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] city = new int[n];
		int max = 0;
		int total = 0;
		int min = 0;
		for (int i = 0; i<n; i++) {
			city[i] = Integer.parseInt(st.nextToken());
			if (max < city[i]) max = city[i];
			total += city[i];
		}
		int m = Integer.parseInt(br.readLine());

		if (total <= m) {
			System.out.println(max);
			return;
		}

		while (min < max) {
			int mid = (min + max)/2;
			long sum = 0;
			for (int x : city) {
				if (mid >= x) sum += x;
				else sum += mid;
			}

			if (sum > m) max = mid;
			else min = mid + 1;

		}

		System.out.println(min-1);


	}
}