package programmers.level1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 덧칠하기 {

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] section = {1,3};
		int result = solution.solution(5, 4, section);

		System.out.println(result);


	}

	static class Solution {
		public int solution(int n, int m, int[] section) {
			int answer = 0;

			// 큐 선언
			Queue<Integer> q = new LinkedList<>();

			// 큐에 section 넣기
			for (int i = 0; i<section.length; i++) {
				q.add(section[i]);
			}

			while (!q.isEmpty()) {
				// 첫번째 값을 기준으로 사용
				int num = q.poll(); //2 6
				answer++;

				if (q.isEmpty()) {
					break;
				}

				// section 다음 숫자가 페인트질 한번에 칠해질수 있는가
				while (num + m - 1 >= q.peek()) {
					q.remove();
					if (q.isEmpty()) {
						break;
					}
				}
			}


			return answer;
		}
	}

}
