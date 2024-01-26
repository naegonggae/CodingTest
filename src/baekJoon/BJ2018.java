package baekJoon;

import java.io.*;

public class BJ2018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int l=1, r=1, cnt=0, sum=0;
		while (r < n) {
			if (sum <= n) sum += r++;
			else sum -= l++;

			if (sum == n) cnt++;
		}

		System.out.println(cnt+1);
	}
}