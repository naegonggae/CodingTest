package programmers.level2;

import java.util.Arrays;
import java.util.Stack;

public class 영어_끝말잇기 {

	public static void main(String[] args) {
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		Solution solution = new Solution();
		int[] result = solution.solution(n, words);
		System.out.println("result = " + Arrays.toString(result));

	}

	static class Solution {
		public int[] solution(int n, String[] words) {
			int[] answer = {0, 0};

			Stack<String> s = new Stack<>();
			s.add(words[0]);
			for (int i = 1; i<words.length; i++) {

				String x = s.peek();

				if (s.contains(words[i])
						|| x.charAt(x.length()-1)!=words[i].charAt(0)) {
					answer[0] = i % n + 1;
					answer[1] = i / n + 1;
					return answer;
				}

				s.add(words[i]);
			}

			return answer;
		}
	}

}
