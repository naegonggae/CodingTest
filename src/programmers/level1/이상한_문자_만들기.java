package programmers.level1;

public class 이상한_문자_만들기 {

	public static void main(String[] args) {

		String s = "try hello world";

		Solution solution = new Solution();
		String result = solution.solution(s);
		System.out.println("result = " + result);

	}

	static class Solution {
		public String solution(String s) {
			String answer = "";

			String ss = s.toUpperCase();
			s = s.toLowerCase();
			int idx = 0;
			for (int i = 0; i<s.length(); i++) {
				if (s.charAt(i) == ' ') {
					idx = 0;
					answer += " ";

				}
				else if (idx == 0) {
					answer += ss.charAt(i);
					idx++;
				} else {
					answer += s.charAt(i);
					idx--;
				}
			}
			return answer;
		}
	}

}
