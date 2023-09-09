package codingTest.arraylist;

public class 격자판_최대합 {
	// https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=72726

	public static void main(String[] args) {
		int n = 5;
		int[][] arr = {{10,13,10,12,15},{12,39,30,23,11},{11,25,50,53,15},{19,27,29,37,27},{19,13,30,13,19}};

		Solution solution = new Solution();
		int result = solution.solution(n, arr);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(int n, int[][] arr) {
			int answer = Integer.MIN_VALUE;
			int sum1, sum2;

			for (int i = 0; i<n; i++) {
				sum1 = sum2 = 0;
				for (int j = 0; j<n; j++) {
					sum1 += arr[i][j];
					sum2 += arr[j][i];
				}
				answer = Math.max(answer, sum1);
				answer = Math.max(answer, sum2);
			}
			sum1 = sum2 = 0;
			for (int i = 0; i<n; i++) {
				sum1 += arr[i][i];
				sum2 += arr[i][n-i-1];
			}
			answer = Math.max(answer, sum1);
			answer = Math.max(answer, sum2);

			return answer;
		}
	}

}
