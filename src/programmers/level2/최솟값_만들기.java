package programmers.level2;

import java.util.Arrays;

public class 최솟값_만들기 {

	public static void main(String[] args) {
		int[] A = {1, 4, 2};
		int[] B = {5, 4, 4};

		Solution solution = new Solution();
		int result = solution.solution(A, B);
		System.out.println("result = " + result);

	}

	static class Solution {
		public int solution(int[] A, int[] B) {
			int answer = 0;

			Arrays.sort(A);
			Arrays.sort(B);
			int len = A.length-1;

			for (int i = 0; i<A.length; i++) {
				answer += A[i] * B[len--];
			}


			return answer;
		}
	}

}
