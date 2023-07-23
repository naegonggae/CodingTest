package programmers.level1;

public class 나머지가_1이_되는_수_찾기 {

	public static void main(String[] args) {
		int n = 99;

		Solution solution = new Solution();
		int result = solution.solution(n);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(int n) {
			int answer = 0;
			// n-1 을 구한다.
			int i = 2;
			while ((n-1) % i != 0) {
				i++;
			}
			return i;
		}
	}

}
