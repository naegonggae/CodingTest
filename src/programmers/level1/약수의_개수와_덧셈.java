package programmers.level1;

public class 약수의_개수와_덧셈 {

	public static void main(String[] args) {
		int left = 13;
		int right = 17;

		Solution solution = new Solution();
		int result = solution.solution(left, right);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(int left, int right) {
			int answer = 0;

			for (int i = left; i<=right; i++) {
				if (count(i)) {
					answer+=i;
				} else {
					answer-=i;
				}
			}

			return answer;
		}

		// 약수의 개수가 홀수개인지 짝수개인지 판별
		private boolean count(int num) {
			for (int i = 1; i*i<=num; i++) {
				if (num % i == 0) {
					int a = num / i;
					if (i == a) {
						return false; // 홀
					}
				}
			}
			return true; // 짝
		}
	}

}
