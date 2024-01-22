package baekJoon;

import java.util.*;
import java.io.*;

public class BJ19598 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		ArrayList<Meeting> al = new ArrayList<>();
		for (int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			al.add(new Meeting(s, e));
		}

		Collections.sort(al);
		Queue<Integer> q = new PriorityQueue<>();
		q.add(al.get(0).e);

		for (int i = 1; i<n; i++) {
			if (q.peek() <= al.get(i).s) {
				q.poll();
			}
			q.add(al.get(i).e);
		}

		System.out.println(q.size());

	}

	static class Meeting implements Comparable<Meeting> {
		int s, e;
		public Meeting(int s, int e) {
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(Meeting o) {
			if (this.s == o.s) return this.e - o.e;
			else return this.s - o.s;
		}
	}
}
