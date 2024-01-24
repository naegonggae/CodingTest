package baekJoon;

import java.util.*;
import java.io.*;

public class BJ2531 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] susi = new int[n];
		for (int i = 0; i<n; i++) {
			susi[i] = Integer.parseInt(br.readLine());
		}

		int r = 0;
		int cnt = 0;
		int max = 0;
		Queue<Integer> set = new LinkedList<>();
		for (int i = 0; i<k; i++) {
			if (!set.contains(susi[i])) {
				cnt++;
			}
			r++;
			set.add(susi[i]);
		}
		if (!set.contains(c)) max = Math.max(max, cnt+1);
		else max = Math.max(max, cnt);

		while (r<n) {
			int removeNum  = set.poll();
			if (!set.contains(removeNum)) cnt--;

			int newNum = susi[r++];
			if (!set.contains(newNum)) cnt++;
			set.add(newNum);

			if (!set.contains(c)) max = Math.max(max, cnt+1);
			else max = Math.max(max, cnt);
		}

		for (int i = 0; i<k-1; i++) {
			int removeNum  = set.poll();
			if (!set.contains(removeNum)) cnt--;

			int newNum = susi[r-n];
			r++;
			if (!set.contains(newNum)) cnt++;
			set.add(newNum);

			if (!set.contains(c)) max = Math.max(max, cnt+1);
			else max = Math.max(max, cnt);
		}

		System.out.println(max);
	}
}