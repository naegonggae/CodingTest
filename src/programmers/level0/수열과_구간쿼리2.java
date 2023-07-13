package programmers.level0;

public class 수열과_구간쿼리2 {

	public int[] solution(int[] arr, int[][] queries) {
		int[] answer = new int[queries.length];

		// i를 찾고 k보다 큰지 확인 그중에 젤 작은 숫자를 모은 배열

		// 2차원 배열 row만큼 진행
		for (int i = 0; i<queries.length; i++) {
			int min = 10000001;
			// 2차원 배열 column들의 조건에 맞는 arr 숫자
			// arr돌면서 있는지 찾는식으로 가자
			for (int j = queries[i][0]; j<=queries[i][1]; j++) {
				// 조건문의 조건이 잘못됨 비교를 인덱스로 해야지 값으로 하니 통과되지 말아야할것들이 통과하지
				if (queries[i][2] < arr[j]) {
					if (min > arr[j]) {
						min = arr[j];
					}
				}
			}
			if (min == 10000001) {
				answer[i] = -1;
			} else {
				answer[i] = min;
			}
		}

		return answer;
	}

}
