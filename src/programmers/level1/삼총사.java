package programmers.level1;

public class 삼총사 {

	public static void main(String[] args) {
		int[] number = {-2, 3, 0, 2, -5};

		Solution solution = new Solution();
		int result = solution.solution(number);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(int[] number) {
			int answer = 0;

			// 중복되는 조합없이 대입해보기
			// 변수에 전 반복문 변수 활용하기
			for (int i = 0; i<number.length; i++) {
				for (int j = i+1; j<number.length; j++) {
					for (int k = j+1; k<number.length; k++) {
						System.out.println(i+" "+j+" "+k);
						if (number[i] + number[j] + number[k] == 0) {
							answer++;
						}
					}
				}
			}

			return answer;
		}
	}

}
