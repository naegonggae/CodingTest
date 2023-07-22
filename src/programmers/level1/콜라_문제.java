package programmers.level1;

public class 콜라_문제 {

	public static void main(String[] args) {
		int a = 3;
		int b = 1;
		int n = 20;

		Solution solution = new Solution();
		int result = solution.solution(a, b, n);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(int a, int b, int n) {
			int answer = 0;

			// n / a = 6받을콜라
			// 소유 콜라 = n - a*6 + 6
			// 소유 콜라 < a 일때까지 반복

			// 소유한 콜라
			int sum = n;

			// 소유한 콜라가 a 보다 작을때까지 반복
			while (sum >= a) {
				// 마트에 몇개 줄건지
				int getC = sum / a;
				// 몇개 돌려받는지
				answer+=getC*b;
				// 소유콜라 최신화
				sum = sum - (getC * a) + (getC*b);
			}

			return answer;
		}
	}

}
