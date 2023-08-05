package programmers.level1;

import java.util.ArrayList;

public class 제일_작은수_제거하기 {

	public static void main(String[] args) {
		int[] arr = {4,3,2,1};

		Solution solution = new Solution();
		ArrayList<Integer> result = solution.solution(arr);
		System.out.println("result = " + result);

	}

	static class Solution {
		public ArrayList<Integer> solution(int[] arr) {

			ArrayList<Integer> al = new ArrayList<>();
			for (int a : arr) {
				al.add(a);
			}

			int min = 999999;
			int idx = 0;
			for (int i = 0; i<arr.length; i++) {
				if (arr[i] < min) {
					min = arr[i];
					idx = i;
				}
			}

			al.remove(al.get(idx));
			//System.out.println(al.get(idx));

			if (al.isEmpty()) {
				al.add(-1);
			}

			return al;
		}
	}

}
