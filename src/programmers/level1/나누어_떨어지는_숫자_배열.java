package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

public class 나누어_떨어지는_숫자_배열 {

	public static void main(String[] args) {

		int[] arr = {5, 9, 7, 10};
		int divisor = 5;

		Solution solution = new Solution();
		ArrayList<Integer> result = solution.solution(arr, divisor);
		System.out.println("result = " + result);

	}

	static class Solution {
		public ArrayList<Integer> solution(int[] arr, int divisor) {
			ArrayList<Integer> answer = new ArrayList<Integer>();

			for (int a : arr) {
				if (a % divisor == 0) {
					answer.add(a);
				}
			}
			if (answer.isEmpty()) {
				answer.add(-1);
			}
			else {
				Collections.sort(answer);
			}
			return answer;
		}
	}

}
