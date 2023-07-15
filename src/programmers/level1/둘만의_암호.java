package programmers.level1;

public class 둘만의_암호 {

	public static void main(String[] args) {
		String s ="aukks";
		String skip = "wbqd";
		int index = 5;

		Solution solution = new Solution();
		String result = solution.solution(s, skip, index);
		System.out.println(result);
	}

	static class Solution {
		public String solution(String s, String skip, int index) {
			String answer = "";
			// text 초기화
			char text = 'a';

			// s 의 길이만큼 반복
			for (int i = 0; i<s.length(); i++) {
				text = s.charAt(i);

				// 인덱스만큼 반복
				for (int j = 0; j<index; j++) {
					// z 가 주어지면 a 로 바꿔주고 아니면 다음 알파벳 호출
					if (text == 'z') {
						text = 'a';
					} else {
						text++;
					}

					// text 가 skip 에 포함 되어있으면 다음 알파벳 호출
					while (skip.contains(String.valueOf(text))) {
						// z 가 주어지면 a 로 바꿔주고 아니면 다음 알파벳 호출
						if (text == 'z') {
							text = 'a';
						} else {
							text++;
						}
					}
				}
				//System.out.println(text);
				answer += String.valueOf(text);
			}

			return answer;
		}
	}
}
