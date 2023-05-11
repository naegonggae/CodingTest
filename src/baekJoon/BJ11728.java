package baekJoon;

import java.util.*;
import java.io.*;

public class BJ11728 {
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n+m];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i<m; i++) {
			arr[n+i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int val : arr) {
			sb.append(val+" ");
		}
		System.out.println(sb);
	}

}
