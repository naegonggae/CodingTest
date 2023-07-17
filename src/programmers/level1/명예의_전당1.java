package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 명예의_전당1 {

	public static void main(String[] args) {
		int k = 3;
		int[] score = {310, 0, 40, 300, 20, 70, 150, 50, 500, 1000};

		Solution solution = new Solution();
		int[] result = solution.solution(k, score);
		System.out.println(Arrays.toString(result));

		Solution2 solution2 = new Solution2();
		int[] result2 = solution2.solution2(k, score);
		System.out.println(Arrays.toString(result2));

		// 근데 사실 이 문제는 우선순위 큐로 푸는 문제였다.
	}

	static class Solution {
		public int[] solution(int k, int[] score) {
			// 정답 코드
			int[] answer = new int[score.length];

			// 실시간 비교 코드
			ArrayList<Integer> arr = new ArrayList<Integer>();

			// Min 값은 2000임 이거땜에 계속틀렸네...
			int min = 3000;

			// 길이가 k 보다 적을 때는 min 값이 구하려는 값임
			for (int i = 0; i<score.length; i++) {
				if (i<k) {
					arr.add(score[i]);
					if (min > score[i]) {
						min = score[i];
					}
					answer[i] = min;
					//System.out.println(arr);

				}
				// k 범위를 초과했다면 계속해서 정렬하면서 k 번째를 뽑아낸다.
				else {
					arr.add(score[i]);
					Collections.sort(arr, Collections.reverseOrder()); // 역순 정렬
					//System.out.println(arr);

					answer[i] = arr.get(k-1); // 인덱스로 뽑는걸 까먹어서 해맸다...
				}

			}
			return answer;
		}
	}

	static class Solution2 {
		public int[] solution2(int k, int[] score) {
			int[] answer = new int[score.length];

			// 우선순위 큐 선언 / 오름차순 정렬
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

			for(int i = 0; i < score.length; i++) {
				priorityQueue.add(score[i]);
				// k 번째만 알면되니까 그 뒤로는 버리자
				if (priorityQueue.size() > k) {
					priorityQueue.remove(); // 제일 작은 숫자 삭제
				}

				// 4개까지는 정렬없이 들어와짐 내부적으로만 유지를 하고 5번째 수가 들어오고 부터는 정렬해서 출력해줌
				//System.out.println(priorityQueue);
				answer[i] = priorityQueue.peek();
			}
			return answer;
		}
	}

}
