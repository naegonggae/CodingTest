package programmers.level1;

import java.util.Arrays;

public class x만큼_간격이_있는_n개의_숫자 {

	public static void main(String[] args) {

		int x = 2;
		int n = 5;

		Solution solution = new Solution();
		long[] result = solution.solution(x, n);
		System.out.println("result = " + Arrays.toString(result));

	}

	static class Solution {
		public long[] solution(int x, int n) {
			long[] answer = new long[n];
			answer[0] = x;
			for (int i = 1; i<n; i++) {
				answer[i] = answer[i-1] + x;
			}
			return answer;
		}
	}

}
