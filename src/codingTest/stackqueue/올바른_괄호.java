package codingTest.stackqueue;

import java.util.Stack;

public class 올바른_괄호 {
	// https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=72745&tab=curriculum

	public static void main(String[] args) {
		String str = "(()(()))(()";

		Solution solution = new Solution();
		String result = solution.solution(str);
		System.out.println("result = " + result);
	}

	static class Solution {
		public String solution(String str) {
			String answer = "NO";

			Stack<Character> stack = new Stack<>();
			for (char c : str.toCharArray()) {
				if (c == ')') {
					if (stack.isEmpty()) return "NO";
					else stack.pop(); // 무조건 여는 괄호니까 조건문 붙일 필요없음
				}
				else stack.add(c);
			}
			if (!stack.isEmpty()) return "NO";

//			int r = 0;
//			int l = 0;
//			while (!stack.empty()) {
//				char c = stack.pop();
//				if (c == '(') r++;
//				else l++;
//			}
//			if (r == l) answer = "YES";

			return answer;
		}
	}
}
