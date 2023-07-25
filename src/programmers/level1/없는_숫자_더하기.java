package programmers.level1;

public class 없는_숫자_더하기 {

	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,6,7,8,0};

		Solution solution = new Solution();
		int result = solution.solution(numbers);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(int[] numbers) {
			int answer = 0;
			int[] arr = new int[10];

			// 배열 인덱스의 숫자가 있는지 체크
			for (int i = 0; i<numbers.length; i++) {
				arr[numbers[i]]++;
			}

			// 인덱스가 1인거 제외하고 i 더하기
			for (int i = 0; i<arr.length; i++) {
				if (arr[i] != 1) {
					answer+=i;
					//System.out.println(i);
				}
			}
			return answer;
		}
	}

}
