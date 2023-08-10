package programmers.level1;

import java.util.ArrayList;

public class 같은_숫자는_싫어 {

	public static void main(String[] args) {

		int[] arr = {1,1,3,3,0,1,1};

		Solution solution = new Solution();
		ArrayList<Integer> result = solution.solution(arr);
		System.out.println("result = " + result);

	}

	static public class Solution {
		public ArrayList<Integer> solution(int[] arr) {
			ArrayList<Integer> answer = new ArrayList<Integer>();
			answer.add(arr[0]);

			for (int i = 1; i<arr.length; i++) {
				if (arr[i-1] == arr[i]) {
					continue;
				} else {
					answer.add(arr[i]);
				}
			}

			return answer;
		}
	}

}
