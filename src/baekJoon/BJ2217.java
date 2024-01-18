package baekJoon;

import java.util.*;
import java.io.*;

public class BJ2217 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Integer[] rope = new Integer[n];
		for (int i = 0; i<n; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(rope, Collections.reverseOrder());
		int total = 0;
		for (int i = 0; i<n; i++) {
			total = Math.max(total, rope[i] * (i+1));
		}
		System.out.println(total);
	}
}
