package programmers.level1;

import java.util.Arrays;
import java.util.Collections;

public class 문자열_내림차순으로_배치하기 {

	public static void main(String[] args) {

		String s = "Zbcdefg";

		Solution solution = new Solution();
		String result = solution.solution(s);
		System.out.println("result = " + result);

	}

	static class Solution {
		public String solution(String s) {
			String answer = "";
			String[] sp = s.split("");

			Arrays.sort(sp, Collections.reverseOrder());
			// System.out.println(Arrays.toString(sp));

			for (String ss : sp) {
				answer+=ss;
			}
			return answer;
		}
	}

}
