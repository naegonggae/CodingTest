package programmers.level1;

public class 크기가작은_부분문자열 {

	public static void main(String[] args) {

		String t = "3141592";
		String p = "271";
		Solution solution = new Solution();
		int result = solution.solution(t, p);
		System.out.println(result);

	}

	static class Solution {
		// p 의 범위는 최대 18자리까지 이기 때문에 Long 으로 해줘야한다.
		public int solution(String t, String p) {
			int answer = 0;
			int l = p.length();
			long intP = Long.valueOf(p);

			// 0-2, 1-3
			for (int i = 0; i<t.length()-l+1; i++) {
				long text = Long.valueOf(t.substring(i, i+l)); // substring() 외우기
				//System.out.println(text);
				if (text <= intP) {
					answer++;
				}
			}

			return answer;
		}
	}

}
