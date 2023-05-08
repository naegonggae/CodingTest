package baekJoon;

import java.util.*;
import java.io.*;

public class BJ10815 {

	static StringBuilder sb = new StringBuilder();
	static int[] num;
	static int[] check;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		num = new int[n];

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		m = Integer.parseInt(bf.readLine());
		check = new int[m];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i<m; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		for (int i = 0; i<check.length; i++) {
			if (bs(check[i])) {
				sb.append(1+" ");
			}
			else {
				sb.append(0+" ");
			}
		}

		System.out.println(sb);
	}
	static boolean bs(int checkNum) {
		int max = num.length;
		int min = 0;
		int mid = 0;

		while (min < max) {
			mid = (max + min) / 2;

			if (checkNum == num[mid]) {
				return true;
			} else if (checkNum < num[mid]) {
				max = mid;

			} else if (checkNum > num[mid]) {
				min = mid + 1;

			}
		}
		return false;
	}
}
