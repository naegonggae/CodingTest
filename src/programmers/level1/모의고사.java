package programmers.level1;

import java.util.ArrayList;

public class 모의고사 {

	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};

		Solution solution = new Solution();
		ArrayList<Integer> result = solution.solution(answers);
		System.out.println("result = " + result);
	}

	static class Solution {
		public ArrayList<Integer> solution(int[] answers) {
			ArrayList<Integer> answer = new ArrayList<Integer>();

			int[] a = {1,2,3,4,5};
			int[] b = {2,1,2,3,2,4,2,5};
			int[] c = {3,3,1,1,2,2,4,4,5,5};
			int aa = 0;
			int bb = 0;
			int cc = 0;

			int l = 0;
			while (answers.length != l) {
				for (int i = 0; i<a.length; i++) {
					if (answers[l] == a[i]) {
						aa++;
					}
					l++;
					if (answers.length == l) {
						break;
					}
				}

			}
			//System.out.println(aa);

			l = 0;
			while (answers.length != l) {
				for (int i = 0; i<b.length; i++) {
					if (answers[l] == b[i]) {
						bb++;
					}
					l++;
					if (answers.length == l) {
						break;
					}
				}

			}
			//System.out.println(bb);

			l = 0;
			while (answers.length != l) {
				for (int i = 0; i<c.length; i++) {
					if (answers[l] == c[i]) {
						cc++;
					}
					l++;
					if (answers.length == l) {
						break;
					}
				}

			}
			//System.out.println(cc);

			if (aa >= bb && aa >= cc) {
				answer.add(1);
				if (aa==bb) {
					answer.add(2);
				}
				if (aa==cc) {
					answer.add(3);
				}
			} else if (bb >= aa && bb >= cc) {
				answer.add(2);
				if (bb==cc) {
					answer.add(3);
				}
			} else {
				answer.add(3);
			}

			return answer;
		}
	}

}
