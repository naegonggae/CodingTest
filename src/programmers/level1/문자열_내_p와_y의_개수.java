package programmers.level1;

public class 문자열_내_p와_y의_개수 {

	public static void main(String[] args) {

		String s = "pPoooyY";

		Solution solution = new Solution();
		boolean result = solution.solution(s);
		System.out.println("result = " + result);

	}

	static class Solution {
		boolean solution(String s) {
			boolean answer = true;

			int p = 0;
			int y = 0;
			for (int i = 0; i<s.length(); i++) {
				if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
					p++;
				}
				if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
					y++;
				}
			}

			if (p != y) {
				answer = false;
			}

			return answer;
		}
	}

}
