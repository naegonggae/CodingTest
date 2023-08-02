package programmers.level1;

import java.util.Arrays;

public class k_번째_수 {

	public static void main(String[] args) {

		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

		Solution solution = new Solution();
		int[] result = solution.solution(array, commands);
		System.out.println("result = " + Arrays.toString(result));
	}

	static class Solution {
		public int[] solution(int[] array, int[][] commands) {
			int[] answer = new int[commands.length];

			int idx = 0;
			for (int i = 0; i<commands.length; i++) {
				idx = 0;
				int[] arr = new int[commands[i][1]-commands[i][0]+2];
				for (int j = commands[i][0]-1; j<commands[i][1]; j++) {

					arr[idx++] = array[j];
				}
				Arrays.sort(arr);
				answer[i] = arr[commands[i][2]];
			}
			return answer;
		}
	}

}
