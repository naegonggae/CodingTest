package programmers.level1;

import java.util.HashMap;

public class 성격_유형_검사하기 {

	public static void main(String[] args) {
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};

		Solution solution = new Solution();
		String result = solution.solution(survey, choices);
		System.out.println("result = " + result);
	}

	static class Solution {
		public String solution(String[] survey, int[] choices) {
			String answer = "";

			// 초이스 점수에 따라 설베이 앞에글자가 점수를 얻냐 뒤에가 얻냐 해서 Map 에 저장
			// 라이벌 유형끼리 비교해서 큰거 출력해서 붙여줘 같으면 사전순
			HashMap<String, Integer> m = new HashMap<>();
			m.put("R", 0); m.put("T", 0);
			m.put("C", 0); m.put("F", 0);
			m.put("J", 0); m.put("M", 0);
			m.put("A", 0); m.put("N", 0);

			for (int i = 0; i<choices.length; i++) {
				if (choices[i] >=1 && choices[i] <= 3) {
					String a = String.valueOf(survey[i].charAt(0));
					m.put(a, m.get(a) + getScore(choices[i]));
				} else if (choices[i] != 4) {
					String a = String.valueOf(survey[i].charAt(1));
					m.put(a, m.get(a) + getScore(choices[i]));
				}
			}
			// 대상유형이랑 점수 비교, 같으면 사전순지정
			// a j c r
			if (m.get("R") == m.get("T")) {
				answer += "R";
			} else if (m.get("R") > m.get("T")) {
				answer += "R";
			} else {
				answer += "T";
			}

			if (m.get("C") == m.get("F")) {
				answer += "C";
			} else if (m.get("C") > m.get("F")) {
				answer += "C";
			} else {
				answer += "F";
			}

			if (m.get("J") == m.get("M")) {
				answer += "J";
			} else if (m.get("J") > m.get("M")) {
				answer += "J";
			} else {
				answer += "M";
			}

			if (m.get("A") == m.get("N")) {
				answer += "A";
			} else if (m.get("A") > m.get("N")) {
				answer += "A";
			} else {
				answer += "N";
			}


			return answer;
		}

		// 점수를 몇점 줘야하는지 리턴
		private int getScore(int choiceNum) {
			if (choiceNum == 1 || choiceNum == 7) {
				return 3;
			} else if (choiceNum == 2 || choiceNum == 6) {
				return 2;
			} else if (choiceNum == 3 || choiceNum == 5) {
				return 1;
			}
			return 0;
		}

	}

}
