package programmers.level1;

import java.util.Arrays;

public class 공원_산책 {

	public static void main(String[] args) {
		String[] park = {"OSO","OOO","OXO","OOO"};
		String[] routes = {"E 2","S 3","W 1"};
		Solution solution = new Solution();
		int[] result = solution.solution(park, routes);
		System.out.println(Arrays.toString(result));
	}

	static class Solution {
		public int[] solution(String[] park, String[] routes) {
			int[] answer = new int[2];
			int x = 0;
			int y = 0;

			// sp 지점 초기화, routes split으로 초기화, isMove() 만들기, move() 메서드만들기
			for (int i = 0; i<park.length; i++) {
				for (int j = 0; j<park[i].length(); j++) {
					String s = String.valueOf(park[i].charAt(j));
					// sp 초기화
					if (s.equals("S")) {
						x = i;
						y = j;
					}
				}
			}

			// 이동명령만큼 반복
			for (int i = 0; i<routes.length; i++) {
				// 이동방향과 정도를 초기화
				String[] split = routes[i].split(" ");
				String drc = split[0];
				int num = Integer.valueOf(split[1]);

				// 다음칸 정보
				int nx = x;
				int ny = y;

				// 이동할수 없는 칸을 만났을때 롤백 정보
				int tempX = x;
				int tempY = y;

				// 이동할 칸만큼 반복
				for (int j = 0; j<num; j++) {
					// 다음칸 반영
					if (drc.equals("N")) {
						nx -=1;
					} else if (drc.equals("S")) {
						nx +=1;
					} else if (drc.equals("W")) {
						ny -=1;
					} else if (drc.equals("E")) {
						ny +=1;
					}

					// 다음칸이 이동할 수 있는지 체크 후 가능하면 반영
					if (isMove(nx, ny, park)) {
						x = nx;
						y = ny;
					} else {
						// 이동할 수 없는칸이면 롤백 후 다음 명령 수행
						x = tempX;
						y = tempY;
						break;
					}
				}

				//System.out.println(x +" "+y);
			}
			answer[0] = x;
			answer[1] = y;
			return answer;
		}

		private Boolean isMove(int nx, int ny, String[] park) {
			// 이동한칸이 "X"가 아님, 0-W, 0-H 범위를 벗어나지 않음
			if (nx >= 0 && ny >= 0 && nx < park.length && ny < park[0].length() && park[nx].charAt(ny) != 'X') {
				// park[nx].charAt(ny) != 'X' 이게 StringIndexOutOfBoundsException 에 걸리지 않는이유
				// if 문을 돌때 차례대로 조건을 따져보나보다 맨앞에 두면 예외터지고 맨 뒤에 두면 예외 안터지고 조건의 기능을 수행했다.

				// 배열을 사용할때는 StringIndexOutOfBoundsException 를 조심하자 인덱스를 조절해가면서 조건검사하는 것은 위험하다.
				return true;
			}

			return false;
		}
	}

}
