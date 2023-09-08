package programmers.level2;

import java.util.ArrayList;

public class n의제곱_배열_자르기 {
	// 구현, 메모리관리 = 최대범위가 백만의 제곱인데 이거를 만개정도 배열에 넣어주면 메모리초과가 나나보다 그래서

	public static void main(String[] args) {
		int n = 4;
		long left = 7;
		long right = 14;

		Solution solution = new Solution();
		ArrayList<Integer> result = solution.solution(n, left, right);
		System.out.println("result = " + result);

	}

	static class Solution {
		public ArrayList<Integer> solution(int n, long left, long right) {
			// 구현 + 메모리 관리
			// 2중 for 문해서 구하려 들면 메모리초과뜸
			ArrayList<Integer> al = new ArrayList<>();
			while (left <= right) {
				long a = left % n;
				long b = left / n;
				if (a >= b) al.add((int)a+1);
				else al.add((int)b+1);
				left++;
			}
			// System.out.println(al);

			return al;
		}
	}

}
