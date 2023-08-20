package programmers.level1;

public class 수박수박수박수박수박수 {

	public static void main(String[] args) {

		int n = 3;

		Solution solution = new Solution();
		String result = solution.solution(n);
		System.out.println("result = " + result);

	}

	static class Solution {
		public String solution(int n) {
			String answer = "";

			String s = "수";
			String ss = "박";

			for (int i = 1; i<=n; i++) {
				if (i % 2 != 0) {
					answer+=s;
				} else {
					answer+=ss;
				}
			}
			return answer;
		}
	}

}
