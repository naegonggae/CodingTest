package baekJoon;

import java.util.*;
import java.io.*;

public class BJ2110 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] home = new int[n];

		for (int i = 0; i<n; i++) {
			home[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(home);
		int max = home[n-1] - home[0] + 1;
		int min = 1;
		int mid = 0;

		while (min < max) {
			long cnt = 1;
			int check = 0;
			mid = (max + min) / 2;

			for (int i = 1; i<home.length; i++) {
				if (home[i] - home[check] >= mid) {
					cnt++;
					check = i;
				}
			}

			if (cnt < c) {
				max = mid;
			}
			else {
				min = mid+1;
			}
		}

		System.out.println(min-1);
	}
}

