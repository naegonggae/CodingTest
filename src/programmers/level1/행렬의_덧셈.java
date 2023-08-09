package programmers.level1;

public class 행렬의_덧셈 {

	public static void main(String[] args) {

		int[][] arr1 = {{1,2},{2,3}};
		int[][] arr2 = {{3,4},{5,6}};

		Solution solution = new Solution();
		int[][] result = solution.solution(arr1, arr2);
		for (int[] ints : result) {
			for (int i : ints) {
				System.out.print(i+" ");
			}
		}
	}

	static class Solution {
		public int[][] solution(int[][] arr1, int[][] arr2) {
			int l = arr1.length;
			int ll = arr1[0].length;
			int[][] answer = new int[l][ll];

			for (int i = 0; i<l; i++) {
				for (int j = 0; j<ll; j++) {
					answer[i][j] = arr1[i][j] + arr2[i][j];
				}
			}

			return answer;
		}
	}

}
