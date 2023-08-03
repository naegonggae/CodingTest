package programmers.level1;

import java.util.Arrays;
import java.util.Collections;

public class 정수_내림차순으로_배치하기 {

	public static void main(String[] args) {

		long n = 118372;

		Solution solution = new Solution();
		long result = solution.solution(n);
		System.out.println("result = " + result);

	}

	// StringBuilder 로 하면 더 빠르다.
	static class Solution {
		public long solution(long n) {
			long answer = 0;

			String nn = String.valueOf(n);

			String[] s = nn.split("");
			Arrays.sort(s, Collections.reverseOrder());
			//System.out.println(s[0]);

			String mm = "";
			for (String m : s) {
				mm+=m;
			}
			answer = Long.valueOf(mm);
			return answer;
		}
	}

}
