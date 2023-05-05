package baekJoon;

import java.util.*;
import java.io.*;

public class BJ1654{

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(bf.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] arr = new int[k];

		long max = 0;

		for (int i = 0; i<k; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		max++;
		long min = 0;
		long mid = 0;

		while (min<max) {
			mid = (min+max) / 2;

			long cnt = 0;
			for (int i = 0; i<arr.length; i++) {
				cnt += (arr[i] / mid);
			}

			if (cnt < n) {
				max = mid;
			}
			else {
				min = mid +1;
			}
		}

		System.out.println(min-1);
	}
}

