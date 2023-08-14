package programmers.level1;

public class 하샤드_수 {

	public static void main(String[] args) {

		int x = 18;

		Solution solution = new Solution();
		boolean result = solution.solution(x);
		System.out.println("result = " + result);

	}

	static class Solution {
		public boolean solution(int x) {
			boolean answer = true;

			String n = String.valueOf(x);
			int sum = 0;
			for (int i = 0; i<n.length(); i++) {
				sum += n.charAt(i)-'0';
			}
			//System.out.println(sum);

			if (x % sum == 0) {
				return answer;
			}
			else {
				answer = false;
			}
			return answer;
		}
	}

}
