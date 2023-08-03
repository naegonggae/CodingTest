package programmers.level1;

import java.util.Arrays;

public class 자연수_뒤집어_배열로_만들기 {

	public static void main(String[] args) {
		long n = 12345;

		Solution solution = new Solution();
		int[] result = solution.solution(n);
		System.out.println("result = " + Arrays.toString(result));
	}

	static class Solution {
		public int[] solution(long n) {

			String nn = String.valueOf(n);

			StringBuilder sb = new StringBuilder(nn);
			nn = sb.reverse().toString();

			String[] s = nn.split("");

			int[] answer = new int[s.length];
			int idx = 0;
			for (String ss : s) {
				answer[idx++] = Integer.valueOf(ss);
			}

			return answer;
		}
	}

}
