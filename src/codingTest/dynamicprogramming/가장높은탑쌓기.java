package codingTest.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;

public class 가장높은탑쌓기 {
	// https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=73424

	static int[] dp;
	static ArrayList<Bricks> al = new ArrayList<>();

	public static void main(String[] args) {
		int n = 5;
		int[][] arr = {{25,3,4},{4,4,6},{9,2,3},{16,2,5},{1,5,2}};

		for (int i = 0; i<n; i++) {
			al.add(new Bricks(arr[i][0], arr[i][1], arr[i][2]));
		}
		dp = new int[n];
		Solution solution = new Solution();
		int result = solution.solution(n, arr);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(int n, int[][] arr) {
			int answer = 0;
			Collections.sort(al);
			dp[0] = al.get(0).h;
			answer = dp[0];
			for (int i = 1; i<n; i++) {
				int max = 0;
				for (int j = i-1; j>=0; j--) {
					if (al.get(j).w > al.get(i).w && max < dp[j]) max = dp[j];
				}
				dp[i] = max + al.get(i).h;
				answer = Math.max(answer, dp[i]);
			}
			return answer;
		}
	}

	static class Bricks implements Comparable<Bricks> {
		int s, h, w;
		public Bricks(int s, int h, int w) {
			this.s = s;
			this.h = h;
			this.w = w;
		}
		@Override
		public int compareTo(Bricks o) {
			return o.s - this.s;
		}
	}
}
