package programmers.level1;

public class 평균구하기 {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4};

		Solution solution = new Solution();
		double result = solution.solution(arr);
		System.out.println("result = " + result);

	}

	static class Solution {
		public double solution(int[] arr) {
			double answer = 0;

			for (int i : arr) {
				answer+=i;
			}

			answer= answer / arr.length;
			return answer;
		}
	}

}
