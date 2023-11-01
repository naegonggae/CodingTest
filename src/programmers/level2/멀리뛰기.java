package programmers.level2;

public class 멀리뛰기 {

	public static void main(String[] args) {
		int n = 5;
		Solution solution = new Solution();
		long result = solution.solution(n);
		System.out.println("result = " + result);
	}

	static class Solution {
		public long solution(int n) {
			int[] dp = new int[n+2]; // 범위 +2해줘임하는 이유는 1번과 2번인덱스를 기본으로 생성해 놔서임
			dp[1] = 1;
			dp[2] = 2;

			for (int i = 3; i<=n; i++) {
				dp[i] = (dp[i-1] + dp[i-2]) % 1234567 ; // long 범위 넘어갈거 생각해서 나머지를 구한다는 생각 할 줄 알아야함
			}
			return dp[n];
		}
	}

}
