package programmers.level2;

import java.util.Stack;

public class 짝지어_제거하기 {

	public static void main(String[] args) {
		String s = "baabaa";
		Solution solution = new Solution();
		int result = solution.solution(s);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(String s) {
			int answer = 0;

			Stack<Character> stack = new Stack<>();
			char[] c = s.toCharArray();
			stack.add(c[0]);
			for (int i = 1; i<c.length; i++) {
				if (!stack.isEmpty() && stack.peek() == c[i]) stack.pop();
				else stack.add(c[i]);
			}

			if (stack.isEmpty()) answer = 1;

			return answer;
		}
	}

}
