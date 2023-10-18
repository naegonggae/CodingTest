package programmers.level2;

import java.util.Stack;

public class 올바른_괄호 {

	public static void main(String[] args) {
		String s = "(()(";
		Solution solution = new Solution();
		boolean result = solution.solution(s);
		System.out.println("result = " + result);
	}

	static class Solution {
		boolean solution(String s) {
			boolean answer = true;

			Stack<String> stack = new Stack<>();
			for (int i = 0; i<s.length(); i++) {
				if (s.charAt(i) == '(') stack.add("(");
				else {
					if (stack.isEmpty()) return false;
					else stack.pop();
				}
			}
			if (!stack.isEmpty()) answer = false;

			return answer;
		}
	}

}
