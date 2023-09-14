package codingTest.dynamicprogramming;

public class 계단오르기 {
	//https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=73421

	static int[] dp;
	public static void main(String[] args) {
		int n = 7;

		dp = new int[n+1];
		Solution solution = new Solution();
		int result = solution.solution(n);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(int n) {
			dp[1] = 1;
			dp[2] = 2;
			for (int i = 3; i<=n; i++) {
				dp[i] = dp[i-2] + dp[i-1];
			}
			return dp[n];
		}
	}

}
