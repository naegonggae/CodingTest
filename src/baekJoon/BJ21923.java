package baekJoon;

import java.util.*;
import java.io.*;

public class BJ21923 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] visit = new int[n];
		for (int i = 0; i<n; i++) {
			visit[i] = Integer.parseInt(st.nextToken());
		}

		int l=0, r=0, sum=0, max=0;
		int maxCount = 0;
		while (true) {
			if (x > r) sum += visit[r++];
			if (x == r) break;
		}
		max = sum;
		maxCount++;
		while (true) {
			sum += visit[r++];
			sum -= visit[l++];

			if (max < sum) {
				max = sum;
				maxCount = 1;
			} else if (max == sum) maxCount++;

			if (r == n) break;
		}

		if (max == 0) System.out.println("SAD");
		else {
			System.out.println(max);
			System.out.println(maxCount);
		}
	}
}