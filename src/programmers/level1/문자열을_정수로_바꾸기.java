package programmers.level1;

public class 문자열을_정수로_바꾸기 {

	public static void main(String[] args) {

		String s = "-1234";

		Solution solution = new Solution();
		int result = solution.solution(s);
		System.out.println("result = " + result);

	}

	static class Solution {
		public int solution(String s) {
			int answer = 0;
			if (s.charAt(0) == '-') {
				String ss = s.substring(1, s.length());
				answer = Integer.valueOf(ss) * -1;
			}
			else {
				answer = Integer.valueOf(s);
			}
			return answer;
		}
	}

}
