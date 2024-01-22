package baekJoon;

import java.util.*;
import java.io.*;

public class BJ13164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 1; i<n; i++) {
			al.add(arr[i] - arr[i-1]);
		}

		Collections.sort(al);
		int sum = 0;
		for (int i = 0; i<n-k; i++) {
			sum += al.get(i);
		}

		System.out.println(sum);

	}
}
