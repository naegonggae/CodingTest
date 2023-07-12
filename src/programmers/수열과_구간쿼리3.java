package programmers;

public class 수열과_구간쿼리3 {

	public int[] solution(int[] arr, int[][] queries) {

		int[] answer = {};

		// 2차원 배열의 row 수만큼 진행 0~2
		for (int i = 0; i<queries.length; i++) {
			// 2차원 배열의 i번째 row마다 j만큼의 column만큼 진행 0~1
			for(int j = 1; j<queries[i].length; j++) {
				int temp = arr[queries[i][j]];
				arr[queries[i][j]] = arr[queries[i][j-1]];
				arr[queries[i][j-1]] = temp;
			}
		}
		return arr;
	}

}
