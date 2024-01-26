package baekJoon;

import java.util.*;
import java.io.*;

public class BJ10025 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[4000001];
		for (int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[x] = g;
		}

		int l=0, r=0, max=0, sum=0;
		for (int i = 0; i<k*2+1; i++) {
			sum += arr[r++];
		}
		if (max < sum) max = sum;
		while (r < 4000000) {
			sum += (arr[r++] - arr[l++]);
			if (max < sum) max = sum;
		}

		System.out.println(max);
	}
}
