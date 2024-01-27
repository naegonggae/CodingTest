package baekJoon;

import java.util.*;
import java.io.*;

public class BJ1253 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int cnt = 0;
		for (int i = 0; i<n; i++) {
			int target = arr[i];
			int l=0, r=n-1;
			while (l<r) {
				int tmp = arr[l] + arr[r];
				if (tmp == target) {
					if (l!=i && r!=i) {
						cnt++;
						break;
					}
					else if (l == i) l++;
					else r--;
				}
				else if (tmp < target) l++;
				else r--;
			}
		}

		System.out.println(cnt);
	}
}