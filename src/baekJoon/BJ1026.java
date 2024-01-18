package baekJoon;

import java.util.*;
import java.io.*;

public class BJ1026 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		Integer[] b = new Integer[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i<n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());

		long sum = 0;
		for (int i = 0; i<n; i++) {
			sum += a[i]*b[i];
		}

		System.out.println(sum);
	}
}