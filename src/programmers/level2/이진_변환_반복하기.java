package programmers.level2;

import java.util.Arrays;

public class 이진_변환_반복하기 {

	public static void main(String[] args) {

		String s = "110010101001";
		Solution solution = new Solution();
		int[] result = solution.solution(s);
		System.out.println("result = " + Arrays.toString(result));
	}

	static class Solution {
		public int[] solution(String s) {

			int zero = 0;
			int cnt = 0;
			String tmp = s;
			while (!tmp.equals("1")) {
				int one = 0;
				cnt++;
				for (int i = 0; i<tmp.length(); i++) {
					if (tmp.charAt(i) == '0') zero++;
					if (tmp.charAt(i) == '1') one++;
				}
				tmp = Integer.toString(one, 2);
			}

			int[] answer = {cnt, zero};
			return answer;
		}
	}

}
