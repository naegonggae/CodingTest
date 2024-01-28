package baekJoon;

import java.util.*;
import java.io.*;

public class BJ10448 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] arr = new int[1000+1];
		for (int i = 1; i<=1000; i++) {
			arr[i] = i * (i+1) / 2;
		}
		for (int i = 0; i<t; i++) {
			int k = Integer.parseInt(br.readLine());
			System.out.println(check(k, arr));
		}
	}

	static int check(int k, int[] arr) {
		for (int j = 1; j<=k; j++) {
			for (int z = 1; z<=k; z++) {
				for (int x = 1; x<=k; x++) {
					if (arr[j]+arr[z]+arr[x] == k) return 1;
				}
			}
		}
		return 0;
	}
}
