package programmers.level1;

import java.util.Arrays;

public class 바탕화면_정리 {

	public static void main(String[] args) {
		String[] wallpaper = {".#...", "..#..", "...#."};
		Solution solution = new Solution();
		int[] result = solution.solution(wallpaper);
		System.out.println(Arrays.toString(result));
	}

	static class Solution {
		public int[] solution(String[] wallpaper) {
			// 위, 왼, 아, 오른 // 위, 왼은 최소값을 구하기 때문에 최대범위 50보다 높게 설정
			int[] answer = {51, 51, 0, 0};

			// 젤 위에 있는 인덱스, 왼 오 아래 인덱스를 알고 서로 조합해서 절댓값 구하면됨 0, 1, 4, 3 / 1, 3, 4, 8 / 아래와 오른쪽은 +1
			for (int i = 0; i<wallpaper.length; i++) {
				for (int j = 0; j<wallpaper[i].length(); j++) {
					String m = String.valueOf(wallpaper[i].charAt(j));
					// i가 제일 작은 것과 높은것
					// j가 제일 낮은 것과 높은것
					if (m.equals("#")) {
						if (i<answer[0]) {
							answer[0] = i;
						}
						if (i+1>answer[2]) {
							answer[2] = i+1;
						}
						if (j<answer[1]) {
							answer[1] = j;
						}
						if (j+1>answer[3]) {
							answer[3] = j+1;
						}
					}
				}
			}

			return answer;
		}
	}

}
