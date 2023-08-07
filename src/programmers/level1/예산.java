package programmers.level1;

import java.util.Arrays;

public class 예산 {

	public static void main(String[] args) {

		int[] d = {1,3,2,5,4};
		int budget = 9;

		Solution solution = new Solution();
		int result = solution.solution(d, budget);
		System.out.println("result = " + result);

	}

	static class Solution {
		public int solution(int[] d, int budget) {
			int answer = 0;

			Arrays.sort(d);
			for (int i : d) {
				if (budget - i < 0) {
					break;
				}
				answer++;
				budget-=i;
			}

			return answer;
		}
	}

}
