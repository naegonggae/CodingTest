package programmers.level1;

public class 음양_더하기 {

	public static void main(String[] args) {
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};

		Solution solution = new Solution();
		int result = solution.solution(absolutes, signs);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(int[] absolutes, boolean[] signs) {
			int answer = 0;
			int idx = 0;

			// 요런 형태로 연습해보자
			for (int i : absolutes) {
				if (signs[idx++] == true) {
					answer+=i;
				} else {
					answer-=i;
				}
			}

			return answer;
		}
	}

}
