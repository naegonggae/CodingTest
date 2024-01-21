package baekJoon;

import java.util.*;
import java.io.*;

public class BJ13904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Test> al = new ArrayList<>();
		for (int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			al.add(new Test(d, w));
		}

		Collections.sort(al);

		int time = 1;
		int sum = 0;
		Queue<Integer> q = new PriorityQueue<>();
		for (Test ob : al) {
			if (ob.d >= time) {
				sum += ob.w;
				q.add(ob.w);
				time++;
			} else {
				if (sum - q.peek() + ob.w > sum) {
					int tmp = q.poll();
					q.add(ob.w);
					sum += (ob.w - tmp);
				}
			}
		}

		System.out.println(sum);
	}

	static class Test implements Comparable<Test> {
		int d, w;
		public Test(int d, int w) {
			this.d = d;
			this.w = w;
		}
		@Override
		public int compareTo(Test o) {
			if (this.d == o.d) return o.w - this.w;
			else return this.d - o.d;
		}
	}
}
