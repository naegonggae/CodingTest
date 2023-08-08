package programmers.level1;

import java.util.Arrays;

public class 최대공약수와_최소공배수 {

	public static void main(String[] args) {

		int n = 3;
		int m = 12;

		Solution solution = new Solution();
		int[] result = solution.solution(n, m);
		System.out.println("result = " + Arrays.toString(result));

	}

	static class Solution {
		public int[] solution(int n, int m) {
			int[] answer = new int[2];
			int num = n*m;

			while(m != 0) {
				int r = n % m;
				n = m;
				m = r;
			}

			answer[0] = n;
			answer[1] = num / n;
			return answer;
		}
	}

}
