package programmers.level1;

public class 약수의_합 {

	public static void main(String[] args) {

		int n = 16;

		Solution solution = new Solution();
		int result = solution.solution(n);
		System.out.println("result = " + result);

	}

	static class Solution {
		public int solution(int n) {
			int answer = 0;
			if (n == 0) {
				return 0;
			}
			for (int i = 1; i*i<=n; i++) {
				if (n % i == 0) {
					answer+=i;
					answer+=n/i;
					if (i == n/i) {
						answer-=i;
					}
				}
			}
			return answer;
		}
	}

}
