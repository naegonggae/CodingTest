package programmers.level1;

public class 자릿수_더하기 {

	public static void main(String[] args) {

		int n = 123;

		Solution solution = new Solution();
		int result = solution.solution(n);
		System.out.println("result = " + result);

	}

	static public class Solution {
		public int solution(int n) {
			int answer = 0;

			String s = String.valueOf(n);
			for (int i = 0; i<s.length(); i++) {
				answer += Integer.valueOf(s.charAt(i)-'0');
			}

			return answer;
		}
	}

}
