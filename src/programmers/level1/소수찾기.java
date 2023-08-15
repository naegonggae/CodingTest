package programmers.level1;

public class 소수찾기 {

	public static void main(String[] args) {

		int n = 10;

		Solution solution = new Solution();
		int result = solution.solution(n);
		System.out.println("result = " + result);

	}

	static class Solution {
		public int solution(int n) {
			int answer = 0;

			for (int i = 2; i<=n; i++) {
				if (i == 2) {
					answer++;
					continue;
				}
				if (isPrime(i)) {
					answer++;
				}
			}
			return answer;
		}

		private boolean isPrime(int n) {
			for (int i = 2; i*i<=n; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

}
