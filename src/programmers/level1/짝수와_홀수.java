package programmers.level1;

public class 짝수와_홀수 {

	public static void main(String[] args) {
		int num = 3;

		Solution solution = new Solution();
		String result = solution.solution(num);
		System.out.println("result = " + result);

	}

	static class Solution {
		public String solution(int num) {
			String answer = "";

			if (num % 2 == 0 || num == 0) {
				answer = "Even";
			}
			else {
				answer = "Odd";
			}
			return answer;
		}
	}

}
