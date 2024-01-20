package baekJoon;

import java.util.*;
import java.io.*;

public class BJ1931 {
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
		int count = 0;
		int time = 0;
		for (Meeting ob : al) {
			if (ob.s >= time) {
				count++;
				time = ob.e;
			}
		}
		System.out.println(count);

	}

	static class Meeting implements Comparable<Meeting> {
		int s, e;
		public Meeting(int s, int e) {
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(Meeting o) {
			if (this.e == o.e) return this.s - o.s;
			else return this.e - o.e;
		}
	}
}