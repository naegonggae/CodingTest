package programmers.level1;

import java.util.LinkedList;
import java.util.Queue;

public class 문자열_나누기 {

	public static void main(String[] args) {
		String s = "abracadabra";
		Solution solution = new Solution();
		int result = solution.solution(s);
		System.out.println(result);
	}

	static class Solution {
		public int solution(String s) {
			int answer = 0;

			// charAt(idx) 가져가면서 조건 검색하면 터지기 마련이다 주의!!
			// 반복문만돌리고 조건비교를 다른 방법으로 해야해
			// queue 이용하면 될듯

			Queue<String> q = new LinkedList<>();
			// 큐에 내용넣기
			for (int i = 0; i<s.length(); i++) {
				String text = String.valueOf(s.charAt(i));
				q.add(text);
			}

			// 변수 선언
			String x;
			String y; // q.poll() 조건문에 바로 쓰면 안되나?
			int cntX = 0;
			int cnt = 0;
			int idx = 0;
			int check = 0;

			// 큐에 내용이 있다면 반복
			while (!q.isEmpty()) {
				// 기준 x
				x = q.poll();
				cntX++;
				idx++;

				while (cntX != cnt) {
					// 다음 글자
					y = q.poll();
					// .poll()이 없는걸 꺼내면 Null 로 꺼내버려서 null 처리해줌
					if (y == null) {
						break;
					}
					idx++;
					//System.out.println(x+ " "+ y);
					// 카운트해줌
					if (x.equals(y)) {
						cntX++;
					} else {
						cnt++;
					}
				}

				// 같으면 answer++, 당시 인덱스 기록
				if (cntX == cnt) {
					answer++;
					check = idx;
					//System.out.println(check);
				}
				//System.out.println(idx);
			}

			// 조건을 만족하지 못하고 끝이나면 카운트 해주기
			if (check != s.length()) {
				answer++;
			}

			return answer;
		}
	}
}
