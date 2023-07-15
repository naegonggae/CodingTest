package programmers.level1;

import java.util.LinkedList;
import java.util.Queue;

public class 카드뭉치 {

	public static void main(String[] args) {
		String[] cards1 = {"i", "drink", "water"};
		String[] cards2 = {"want", "to"};
		String[] goal = {"i", "want", "to", "drink", "water"};

		Solution solution = new Solution();
		String result = solution.solution(cards1, cards2, goal);
		System.out.println(result);
	}

	static class Solution {
		public String solution(String[] cards1, String[] cards2, String[] goal) {
			String answer = "Yes";

			// queue 생성, cards 에 있는 내용 각각 큐에 담기
			Queue<String> q = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();

			for (int i = 0; i<cards1.length; i++) {
				q.add(cards1[i]);
			}
			for (int i = 0; i<cards2.length; i++) {
				q2.add(cards2[i]);
			}

			for (int i = 0; i<goal.length; i++) {
				// goal 에 있는 내용 하나하나 비교하면서 있으면 큐에서 삭제
				if (goal[i].equals(q.peek())) {
					q.remove();
				}
				else if (goal[i].equals(q2.peek())) {
					q2.remove();
				}
				// 두개의 큐에 내용이 없으면 실패로 간주하고 종료
				else {
					answer = "No";
					break;
				}
			}
			return answer;
		}
	}

}
