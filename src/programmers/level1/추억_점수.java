package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class 추억_점수 {

	public static void main(String[] args) {

		String[] name = {"may", "kein", "kain", "radi"};
		int[] yearning = {5, 10, 1, 3};
		String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"},{"kon", "kain", "may", "coni"}};

		Solution solution = new Solution();
		int[] result = solution.solution(name, yearning, photo);

		System.out.println(Arrays.toString(result));

	}

	static class Solution {
		public int[] solution(String[] name, int[] yearning, String[][] photo) {
			int[] answer = new int[photo.length];

			// Map 선언
			HashMap<String, Integer> map = new HashMap<>();

			// 이름과 그리움점수를 Map 에 저장
			for (int i = 0; i<name.length; i++) {
				map.put(name[i], yearning[i]);
			}

			// photo 의 각 배열마다 추억점수 합 변수 선언
			int sum = 0;

			for (int i = 0; i<photo.length; i++) {
				for (int j = 0; j<photo[i].length; j++) {

					// map 에 key 값이 저장 되어있는지 확인
					if (map.containsKey(photo[i][j])) {

						// 있다면 총합구하기
						sum += map.get(photo[i][j]);
					}
				}
				// 배열저장 후 sum 초기화
				answer[i] = sum;
				sum = 0;
			}

			return answer;
		}
	}

}
