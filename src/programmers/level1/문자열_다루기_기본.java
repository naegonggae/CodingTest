package programmers.level1;

public class 문자열_다루기_기본 {

	public static void main(String[] args) {

		String s = "a234";

		Solution solution = new Solution();
		boolean result = solution.solution(s);
		System.out.println("result = " + result);

	}

	static class Solution {
		public boolean solution(String s) {
			boolean answer = false;
			if (s.length() == 4 || s.length() == 6) {
				answer = true;
			}

			for (int i = 0; i<s.length(); i++) {
				if (s.charAt(i)-'0' < 0 || s.charAt(i)-'0' > 9) {
					answer = false;
				}
			}
			return answer;
		}
	}

}
