package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 달리기_경주 {

	public static void main(String[] args) {
		String[] players = {"mumu", "soe", "poe", "kai", "mine"};
		String[] callings = {"kai", "kai", "mine", "mine"};

		Solution2 solution2 = new Solution2();
		String[] result2 = solution2.solution(players, callings);
		System.out.println(Arrays.toString(result2));

		Solution solution = new Solution();
		String[] result = solution.solution(players, callings);
		System.out.println(Arrays.toString(result));

	}
	static class Solution {
		public String[] solution(String[] players, String[] callings) {

			// Map 으로 등수 기록
			HashMap<String, Integer> m = new HashMap<>();
			for (int i = 0; i<players.length; i++) {
				m.put(players[i], i);
			}

			for (int i = 0; i<callings.length; i++) {
				// 인덱스로 활용
				int score = m.get(callings[i]);

				// 자리 바꾸기
				String temp = players[score];
				players[score] = players[score-1];
				players[score-1] = temp;
				//System.out.println(players[score]);

				// map 에 바뀐 등수 기록, map 을 기록표처럼 사용한게 포인트
				m.replace(callings[i], score-1);
				m.replace(players[score], score);
			}

			return players;
		}
	}

	static class Solution2 {
		public String[] solution(String[] players, String[] callings) {
			String[] answer = new String[players.length];

			// Map 으로 등수 기록
			HashMap<String, Integer> m = new HashMap<>();
			for (int i = 0; i<players.length; i++) {
				m.put(players[i], i+1);
			}

			// map 에서 불린 이름
			for (int i = 0; i<callings.length; i++) {
				// 콜링에서 불린 이름 호출
				String name = callings[i]; //kai
				// map 에서 호출된 이름이 몇등인지 조회
				Integer v = m.get(name); //4
				// 변수 선언
				String n;

				// value 로 key 찾기
				for (Map.Entry<String, Integer> e : m.entrySet()) {
					// 호출된 이름보다 등수가 하나 높은 사람 찾기
					if (e.getValue() == v-1) {
						// 그 이름 변수에 담고
						n = e.getKey(); // poe
						//System.out.println(n);
						// map 에 등수 한단계 낮추기
						m.replace(n, m.get(n)+1); //4
					}
				}
				// 콜링에서 호출된 사람은 등수 한단계 높이기
				m.replace(name, v-1); //3
			}

			// map 에서 0부터 콜링 길이 만큼 반복문을 돌려 해당 등수를 인덱스 삼아 정렬
			for (int i = 0; i<players.length; i++) {
				Integer s = m.get(players[i]);
				answer[s-1] = players[i];
			}

			return answer;
		}
	}

}
