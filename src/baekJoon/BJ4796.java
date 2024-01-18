package baekJoon;

import java.util.*;
import java.io.*;

public class BJ4796 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			if (l==0 && p==0 && v==0) break;

			int count = 0;
			count += v / p * l;
			count += (v%p) >= l ? l : v%p;
			System.out.println("Case "+cnt+": "+count);
			cnt++;
		}
	}
}
