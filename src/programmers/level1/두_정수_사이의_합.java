package programmers.level1;

public class 두_정수_사이의_합 {

	public static void main(String[] args) {

		int a = 5;
		int b = 3;

		Solution solution = new Solution();
		long result = solution.solution(a, b);
		System.out.println("result = " + result);

	}

	static class Solution {
		public long solution(int a, int b) {
			long answer = 0;

			for (int i = Math.min(a, b); i<=Math.max(a, b); i++) {
				answer+=i;
			}
			return answer;
		}
	}

}
