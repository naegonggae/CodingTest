package baekJoon;

import java.util.*;
import java.io.*;

public class BJ1644 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n+1];
		for (int i = 2; i<=n; i++) {
			if (isPrime(i)) {
				arr[i] = i;
			}
		}

		int l=2, r=2, cnt=0, sum=0;
		while (r <= n) {
			if (arr[r] == 0) {
				r++;
				continue;
			}
			if (arr[l] == 0) {
				l++;
				continue;
			}
			if (sum <= n) sum += arr[r++];
			else sum -= arr[l++];

			if (sum == n) cnt++;
		}

		while (sum > n) {
			sum -= arr[l++];
			if (sum == n) cnt++;

		}

		System.out.println(cnt);
	}

	static boolean isPrime(int m) {
		for (int i = 2; i*i<=m; i++) {
			if (m % i == 0) return false;
		}
		return true;
	}
}
