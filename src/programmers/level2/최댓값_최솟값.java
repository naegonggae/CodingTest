package programmers.level2;

public class 최댓값_최솟값 {

	public static void main(String[] args) {
		String s = "-1 -2 -3 -4";
		Solution solution = new Solution();
		String result = solution.solution(s);
		System.out.println("result = " + result);

	}

	static class Solution {
		public String solution(String s) {
			String[] strArr = s.split(" ");
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (String str : strArr) {
				int tmp = Integer.valueOf(str); // 그냥 음수 표시도 해석해버리네
				if (tmp > max) max = tmp;
				if (tmp < min) min = tmp;
			}
			String answer = min + " " + max;
			return answer;
		}
	}

}
