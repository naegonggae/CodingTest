package codingTest.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class 결혼식 {
	// https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=73414

	public static void main(String[] args) {
		int n = 5;
		int[][] arr = {{14,18},{12,15},{15,20},{20,30},{5,14}};


		Solution solution = new Solution();
		int result = solution.solution(n, arr);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(int n, int[][] arr) {
			int answer = Integer.MIN_VALUE;

			ArrayList<Time> al = new ArrayList<>();
			for (int[] i : arr) {
				al.add(new Time(i[0], 's'));
				al.add(new Time(i[1], 'e'));
			}

			Collections.sort(al);
			System.out.println(al);
			int cnt = 0;
			for (Time x : al) {
				if (x.e == 's') {
					cnt++;
					answer = Math.max(answer, cnt);
				}
				else cnt--;
//				System.out.print(cnt+" ");
			}

			return answer;
		}
	}

	static class Time implements Comparable<Time> {
		int s;
		char e;
		public Time(int s, char e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Time o) {
			if (this.s == o.s) return this.e - o.e;
			else return this.s - o.s;
		}

		@Override
		public String toString() {
			return "Time{" +
					"s=" + s +
					", e=" + e +
					'}';
		}
	}

}
