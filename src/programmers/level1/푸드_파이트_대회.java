package programmers.level1;

public class 푸드_파이트_대회 {

	public static void main(String[] args) {
		int[] food = {1, 3, 4, 6};
		Solution solution = new Solution();
		String result = solution.solution(food);
		System.out.println("result = " + result);
	}

	static class Solution {
		public String solution(int[] food) {
			String answer = "";

			// 짝수개만 살려서 A 참가자 배치함
			for (int i = 1; i<food.length; i++) {
				int a = food[i] / 2;
				for (int j = 0; j<a; j++) {
					answer+=String.valueOf(i);
				}
			}

			// A 참가자 배치 리버스해서 B 참가자 배치 만듬
			StringBuffer sb = new StringBuffer(answer);
			String n = sb.reverse().toString();

			// 중간에 0
			answer+="0";
			answer+=n;

			return answer;
		}
	}

}
