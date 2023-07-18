package programmers.level1;

import java.util.Arrays;

public class 과일장수 {

	public static void main(String[] args) {
		int k = 3;
		int m = 4;
		int[] score = {1,2,3,1,2,3,1};

		Solution solution = new Solution();
		int result = solution.solution(k, m, score);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(int k, int m, int[] score) {
			int answer = 0;

			// 1~k 점수, m개씩 상자에포장, 상자에서 가장낮은게 p면 한상자가격은 p*m, 최대이윤추구
			// 남은사과버리기 가능, 가능한 많은 사과 팔기, p*m*상자수 리턴
			int idx = score.length;

			// 크기가 높은 것들끼리 한상자에 넣으면 효율이 좋다.
			Arrays.sort(score);

			for (int i = m; i<=idx; i+=m) {
				answer+=score[idx-i]*m;
			}
			return answer;
		}
	}

}
