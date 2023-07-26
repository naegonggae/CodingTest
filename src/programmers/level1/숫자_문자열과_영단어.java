package programmers.level1;

public class 숫자_문자열과_영단어 {

	public static void main(String[] args) {
		String s = "one4seveneight";

		Solution solution = new Solution();
		int result = solution.solution(s);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(String s) {
			int answer = 0;

			// 배열에 담으면 더 깔끔할듯
			s = s.replace("one", "1");
			s = s.replace("two", "2");
			s = s.replace("three", "3");
			s = s.replace("four", "4");
			s = s.replace("five", "5");
			s = s.replace("six", "6");
			s = s.replace("seven", "7");
			s = s.replace("eight", "8");
			s = s.replace("nine", "9");
			s = s.replace("zero", "0");
			//System.out.println(s);

			answer = Integer.valueOf(s);
			return answer;
		}
	}

}
