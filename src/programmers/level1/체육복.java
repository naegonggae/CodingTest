package programmers.level1;

import java.util.Arrays;

public class 체육복 {

	public static void main(String[] args) {

		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};

		Solution solution = new Solution();
		int result = solution.solution(n, lost, reserve);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(int n, int[] lost, int[] reserve) {
			int answer = n - (lost.length);

			// 정렬된 상태라고 조건에서 말한적은 없어..
			Arrays.sort(lost);
			Arrays.sort(reserve);
			for (int i = 0; i<lost.length; i++) {
				int l = lost[i];
				for (int k = 0; k<reserve.length; k++) {
					if (l == reserve[k]) {
						reserve[k] = 100;
						lost[i] = 200;
						answer++;
						break;
					}
				}
			}

			for (int i = 0; i<lost.length; i++) {
				int l = lost[i];
				if (l == 200) {
					continue;
				}

				for (int j = 0; j<reserve.length; j++) {
					if (reserve[j] == 100) {
						continue;
					}//1, .2, .3, .4, 5, .6
					else if (l == reserve[j]-1) {
						reserve[j] = 100;
						answer++;
						break;
					}
					else if (l == reserve[j]+1) {
						reserve[j] = 100;
						answer++;
						break;
					}
				}
			}
			return answer;
		}
	}

}
