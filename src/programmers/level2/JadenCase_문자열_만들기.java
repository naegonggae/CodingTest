package programmers.level2;

public class JadenCase_문자열_만들기 {

	public static void main(String[] args) {
		String s = "3people unFollowed me";
		Solution solution = new Solution();
		String result = solution.solution(s);
		System.out.println("result = " + result);

	}

	static class Solution {
		public String solution(String s) {
			char[] c = s.toCharArray();
			String answer = String.valueOf(Character.toUpperCase(c[0]));

			for (int i = 1; i<c.length; i++) {
				char tmp = '0';
				if (!Character.isAlphabetic(c[i])) tmp = c[i];
				else if (c[i-1] == ' ') tmp = Character.toUpperCase(c[i]);
				else tmp = Character.toLowerCase(c[i]);
				answer += tmp;
			}

			return answer;
		}
	}

}
