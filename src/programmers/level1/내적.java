package programmers.level1;

public class 내적 {

	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};

		Solution solution = new Solution();
		int result = solution.solution(a, b);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(int[] a, int[] b) {
			int answer = 0;

			for (int i = 0; i<a.length; i++) {
				answer+=a[i]*b[i];
			}

			return answer;
		}
	}
}
