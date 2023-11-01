package programmers.level2;

import java.util.Stack;

public class 괄호_회전하기 {

	public static void main(String[] args) {
		String s = "[](){}";
		Solution solution = new Solution();
		int result = solution.solution(s);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(String s) {
			int answer = 0;
			String str = s;
			if (isOk(str)) answer++;
			for (int i = 1; i<s.length(); i++) {
				str = str.substring(1) + str.charAt(0);
				// System.out.println(str);
				if (isOk(str)) answer++;
			}
			return answer;
		}

		private boolean isOk(String str) {
			Stack<Character> stack = new Stack<>();
			for (char c : str.toCharArray()) {
				if (c=='(' || c=='{' || c=='[') stack.add(c);
				else if (!stack.isEmpty()){
					if (c == ')' && stack.peek()=='(') stack.pop();
					else if (c == '}' && stack.peek()=='{') stack.pop();
					else if (c == ']' && stack.peek()=='[') stack.pop();
				}
				else {
					return false;
				}
			}

			if (stack.isEmpty()) return true;
			return false;
		}
	}

}
