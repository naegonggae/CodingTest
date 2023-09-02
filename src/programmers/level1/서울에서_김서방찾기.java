package programmers.level1;

public class 서울에서_김서방찾기 {

	public static void main(String[] args) {

		String[] seoul = {"Jane", "Kim"};

		Solution solution = new Solution();
		String result = solution.solution(seoul);
		System.out.println("result = " + result);

	}

	static class Solution {
		public String solution(String[] seoul) {
			String answer = "";
			int idx = 0;
			for (String s : seoul) {
				if (s.equals("Kim")) {
					break;
				}
				idx++;
			}

			answer += "김서방은 ";
			answer += String.valueOf(idx);
			answer += "에 있다";
			return answer;
		}
	}

}
