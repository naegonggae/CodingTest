package programmers.level1;

import java.util.Arrays;

public class 로또의_최고순위와_최저순위 {

	public static void main(String[] args) {

		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};

		Solution solution = new Solution();
		int[] result = solution.solution(lottos, win_nums);
		System.out.println("result = " + Arrays.toString(result));
	}

	static class Solution {
		public int[] solution(int[] lottos, int[] win_nums) {
			int[] answer = new int[2];

			// 최고는 0을 다 당첨이라 생각하면되지 나머지가 얼마나 맞았냐 생각
			// 최저는 0은 다 틀리고 나머지가 얼마나 맞았냐
			int cnt = 0;
			int zero = 0;

			// 6*6의 시간복잡도인데 12의 시간복잡도로도 구현가능함 map 에 저장해서
			for (int i = 0; i<6; i++) {
				for (int j = 0; j<6; j++) {
					if (win_nums[i] == lottos[j]) {
						cnt++;
					}
				}
				if (lottos[i] == 0) {
					zero++;
				}
			}

			answer[0] = score(cnt + zero);
			answer[1] = score(cnt);

			return answer;
		}

		// 이렇게 안만들고 7에서 빼면됐음...
		private int score(int cnt) {
			if (cnt == 6) {
				return 1;
			} else if (cnt == 5) {
				return 2;
			} else if (cnt == 4) {
				return 3;
			} else if (cnt == 3) {
				return 4;
			} else if (cnt == 2) {
				return 5;
			}
			return 6;
		}
	}

}
