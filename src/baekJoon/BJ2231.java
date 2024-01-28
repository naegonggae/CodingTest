package baekJoon;

import java.io.*;

public class BJ2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;

		for (int i = 0; i<n; i++) {
			int sum = 0;
			sum += i;
			int m = i;
			while (m % 10 != 0) {
				sum += m % 10;
				m /= 10;
			}
			if (sum == n) {
				result = i;
				break;
			}
		}

		System.out.println(result);
	}
}
