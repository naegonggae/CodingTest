package programmers.level1;

import java.util.HashMap;

public class 숫자_짝꿍 {

	public static void main(String[] args) {
		String X = "5525";
		String Y = "1255";

		Solution solution = new Solution();
		String result = solution.solution(X, Y);
		System.out.println("result = " + result);
	}

	static class Solution {
		public String solution(String X, String Y) {
			String answer = "";

			//charAt 해서 0~9까지를 인덱스 삼아 카운트함 x,y각각, 초기값은 n으로하자
			//둘다 n이 아닐때 둘중 작은 숫자로 재료삼음
			//재료중 젤큰수부터 내림차순으로 넣기
			// 근데 시간초과남 자릿수가 3백만이라는건 얼마나 큰수를 말하는걸까...
			// 백만자리수를 의미할까

			// 시간초과를 해결하고 싶다면 StringBuilder 를 고려해보자

			HashMap<Integer, Integer> mx = new HashMap<>();
			HashMap<Integer, Integer> my = new HashMap<>();
			StringBuilder sb = new StringBuilder();

			// map 에 나온숫자 갯수 저장
			for (int i = 0; i<X.length(); i++) {
				int a = Integer.valueOf(X.charAt(i)-'0');
				if (mx.containsKey(a)) {
					mx.put(a, mx.get(a)+1);
				} else {
					mx.put(a, 1);
				}
			}
			for (int i = 0; i<Y.length(); i++) {
				int a = Integer.valueOf(Y.charAt(i)-'0');
				if (my.containsKey(a)) {
					my.put(a, my.get(a)+1);
				} else {
					my.put(a, 1);
				}
			}

			// 0~9 중에 둘다 카운트 된게 있으면 그중 최소값으로 해당 문자를 더한다.
			for (int i = 9; i>=0; i--) {
				if (mx.containsKey(i) && my.containsKey(i)) {
					int idx = Math.min(mx.get(i), my.get(i));
					for (int j = 0; j<idx; j++) {
						sb.append(String.valueOf(i));
					}
				}
			}

			// 공백이면 -1, 0이 여러개 쌓이면 그냥 0하나 출력하게 만듬
			String aaa = sb.toString();
			if (aaa.equals("")) {
				sb.append(-1);
			} else if ((aaa.substring(0, 1)).equals("0")) {
				return "0";
			}
			return sb.toString();
		}
	}

}
