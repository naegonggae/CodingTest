package programmers.level1;

import java.util.Arrays;

public class 비밀지도_1차 {

	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};

		Solution solution = new Solution();
		String[] result = solution.solution(n, arr1, arr2);
		System.out.println("result = " + Arrays.toString(result));

	}

	static class Solution {
		public String[] solution(int n, int[] arr1, int[] arr2) {
			String[] answer = new String[n];
			String[] s1 = new String[n];
			String[] s2 = new String[n];

			// 이걸 해줘야 null이란 게 안뜨네...
			for (int i = 0; i<n; i++) {
				s1[i] = "";
				s2[i] = "";
				answer[i] = "";
			}

			for (int i = 0; i<n; i++) {
				String ss1 = Integer.toString(arr1[i], 2);
				String ss2 = Integer.toString(arr2[i], 2);
				if (ss1.length() < n) {
					for (int j = 0; j<n-ss1.length(); j++) {
						s1[i]+="0";
					}
				}
				if (ss2.length() < n) {
					for (int j = 0; j<n-ss2.length(); j++) {
						s2[i]+="0";
					}
				}
				s1[i] += ss1;
				s2[i] += ss2;
			}

			for (int i = 0; i<n; i++) {
				for (int j = 0; j<n; j++) {
					int a1 = Integer.valueOf(s1[i].charAt(j)-'0');
					int a2 = Integer.valueOf(s2[i].charAt(j)-'0');
					if (a1 == 1 || a2 == 1) {
						answer[i] += "#";
					} else {
						answer[i] += " ";
					}
				}
			}

			return answer;
		}
	}

}
