package programmers.level2;

public class 숫자의_표현 {

	public static void main(String[] args) {
		int n = 15;
		Solution solution = new Solution();
		int result = solution.solution(n);
		System.out.println("result = " + result);

	}

	static class Solution {
		public int solution(int n) {
			int answer = 0;
			int sum = 0;
			int lt = 1;
			int rt = 1;
			while (rt<=n+1) {

				if (sum < n) {
					sum += rt++;
					if (sum == n) answer++;
				}
				else {
					while (sum >= n) {
						sum -= lt++;
						if (sum == n) answer++;
					}
				}
			}
			return answer;
		}
	}

}
