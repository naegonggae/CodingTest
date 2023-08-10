package programmers.level1;

public class 시저_암호 {

	public static void main(String[] args) {

		String s = "a B z";
		int n = 1;

		Solution solution = new Solution();
		String result = solution.solution(s, n);
		System.out.println("result = " + result);

	}

	static class Solution {
		public String solution(String s, int n) {
			String answer = "";
			// 공백은 넘어가고 대문자 소문자 구분
			// 효율이 참 안좋다..
			for (int i = 0; i<s.length(); i++) {
				char c = s.charAt(i);
				if (c >= 'A' && c <= 'Z') {
					c += n;
					if (c > 'Z') {
						c += -26;
					}
					answer += c;
				}
				else if (c >= 'a' && c <= 'z') {
					c += n;
					if (c > 'z') {
						c += -26;
					}
					answer += c;
				}
				else if (c == ' ') {
					answer += " ";
				}
			}

			return answer;
		}
	}

}
