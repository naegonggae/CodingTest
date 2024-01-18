package baekJoon;

import java.util.*;
import java.io.*;

public class BJ1449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int count = 0;
		int pipe = 0;
		for (int i = 0; i<n; i++) {
			if (pipe <= arr[i]) {
				pipe = arr[i] + l;
				count++;
			}
		}

		System.out.println(count);
	}
}
