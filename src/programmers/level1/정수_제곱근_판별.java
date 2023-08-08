package programmers.level1;

public class 정수_제곱근_판별 {

	public static void main(String[] args) {

		long n = 121;

		Solution solution = new Solution();
		long result = solution.solution(n);
		System.out.println("result = " + result);

	}

	static class Solution {
		public long solution(long n) {
			// long 으로 다 잡아줘야 한다.
			long answer = -1;
			long num = (long) Math.sqrt(n);
			//System.out.println(num);

			if (num*num == n) {
				answer = (num+1)*(num+1);
			}

			return answer;
		}
	}

}
