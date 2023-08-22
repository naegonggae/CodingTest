package programmers.level1;

public class 콜라츠_추측 {

	public static void main(String[] args) {

		int num = 626331;

		Solution solution = new Solution();
		int result = solution.solution(num);
		System.out.println("result = " + result);

	}

	static class Solution {
		public int solution(int num) {
			int cnt = 0;
			long n = num; // int 범위를 넘어가는 연산이 있음...

			if (n == 1) {
				return 0;
			}

			while (n != 1) {

				if (cnt == 500) {
					return -1;
				}
				if (n % 2 == 0) {
					n = n / 2;
				}
				else {
					n = (n * 3) + 1;
				}
				cnt++;

			}
			return cnt;
		}
	}
}
