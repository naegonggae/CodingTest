package programmers.level1;

public class 부족한_금액_계산하기 {

	public static void main(String[] args) {

		int price = 3;
		int money = 20;
		int count = 4;

		Solution solution = new Solution();
		long result = solution.solution(price, money, count);
		System.out.println("result = " + result);

	}

	static class Solution {
		public long solution(int price, int money, int count) {
			long answer = 0;

			// 3 6 9 12 = 30 20 =10
			for (int i = 1; i<=count; i++) {
				answer += price*i;
			}

			// 돈이 부족하지 않으면 0리턴
			if (answer <= money) {
				return 0;
			} else {
				answer = answer - money;
			}

			return answer;
		}
	}

}
