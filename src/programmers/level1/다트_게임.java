package programmers.level1;

import java.util.ArrayList;

public class 다트_게임 {

	public static void main(String[] args) {

		String dartResult = "1D#2S*3S";

		Solution solution = new Solution();
		int result = solution.solution(dartResult);
		System.out.println("result = " + result);

	}

	static class Solution {
		public int solution(String dartResult) {
			int answer = 0;

			ArrayList<Integer> al = new ArrayList<>();
			int idx = -1;

			for (int i = 0; i<dartResult.length(); i++) {
				char c = dartResult.charAt(i);
				if (c == 'S') {
					int num = Integer.valueOf(dartResult.charAt(i-1)-'0');
					if (i != 1 && num == 0 &&
							Integer.valueOf(dartResult.charAt(i-2)-'0') == 1) {
						al.add(10);
						idx++;
					} else {
						al.add(num);
						idx++;
					}
				}
				else if (c == 'D') {
					int num = Integer.valueOf(dartResult.charAt(i-1)-'0');
					if (i != 1 && num == 0 &&
							Integer.valueOf(dartResult.charAt(i-2)-'0') == 1) {
						al.add(10*10);
						idx++;
					} else {
						al.add(num*num);
						idx++;
					}
				}
				else if (c == 'T') {
					int num = Integer.valueOf(dartResult.charAt(i-1)-'0');
					if (i != 1 && num == 0 &&
							Integer.valueOf(dartResult.charAt(i-2)-'0') == 1) {
						al.add(10*10*10);
						idx++;
					} else {
						al.add(num*num*num);
						idx++;
					}
				}
				else if (c == '*') {
					if (idx == 0) {
						al.set(idx, al.get(idx)*2);
					} else {
						al.set(idx, al.get(idx)*2);
						al.set(idx-1, al.get(idx-1)*2);
					}
				}
				else if (c == '#') {
					al.set(idx, al.get(idx)*(-1));
				}
			}

			for (int i : al) {
				answer+=i;
			}

			return answer;
		}
	}

}
